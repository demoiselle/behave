<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Relatório de Regressão de Layout</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.2.2/ekko-lightbox.min.css">
	
    
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<style>
body, .main-container {
	padding: 0px;
	margin: 0px;
}

* {
	font-family: 'Lato', sans-serif;
	font-size: 13px;
}

.table-comparison img {
	border: 1px solid #ccc;
	margin: 10px; 
}
.btn-group .btn-primary {

}
</style>
</head>

<body>

	<div class="container-fluid main-container">

		<h1>Relatório de Regressão de Layout</h1>

		<table class="table table-hover table-comparison table-responsive">
			<thead>
				<tr>
					<#list columnHeaders as columnHeader>
					<th class="text-nowrap">${columnHeader}</th> 
					</#list>
				</tr>
			</thead>
			<tbody>
				<#list resultRows as resultRow>
				<tr>
					<td class="text-nowrap">${resultRow.getName()}</td>
					<td>
						<a href="${resultRow.getExpectedFileNameReport()}" data-toggle="lightbox" data-gallery="multiimages" data-title="Referência">
							<img src="${resultRow.getExpectedFileNameReport()}" width="300" />
						</a>
					</td>
					
					<#list resultRow.getBrowsers() as browser>
					<td>
						<div class="row text-center">
							<a href="${browser.getOriginalFileNameReport()}" id="${browser.getName()}-original" data-toggle="lightbox" data-gallery="multiimages" data-title="${browser.getName()}">
								<img src="${browser.getOriginalFileNameReport()}" width="250" />
							</a>
							
							<a href="${browser.getPngFileNameReport()}" id="${browser.getName()}-png" data-toggle="lightbox" data-gallery="multiimages" data-title="Imagem comparativa do ${browser.getName()}" style="display: none;">
								<img src="${browser.getPngFileNameReport()}" width="250" />
							</a>
							
							<a href="${browser.getGifFileNameReport()}" id="${browser.getName()}-gif" data-toggle="lightbox" data-gallery="multiimages" data-title="Animação comparativa do ${browser.getName()}" style="display: none;">
								<img src="${browser.getGifFileNameReport()}" width="250" />
							</a>
						</div>
						<div class="row text-center">
							<div class="btn-group btn-radios" data-toggle="buttons">
							  <label class="btn btn-primary active btn-sm" id="${browser.getName()}-original_btn">
							    <input type="radio" name="options" id="option1" autocomplete="off"> Original
							  </label>
							  <label class="btn btn-primary btn-sm" id="${browser.getName()}-png_btn">
							    <input type="radio" name="options" id="option1" autocomplete="off"> Estática
							  </label>
							  <label class="btn btn-primary btn-sm" id="${browser.getName()}-gif_btn">
							    <input type="radio" name="options" id="option2" autocomplete="off"> Dinâmica
							  </label>
							</div>
							
							<span id="helpBlock" class="help-block">Diferença com a
								referência: <strong>${browser.getPercentageDeviation()}%</strong>
							</span>
						</div>				
					</td> 
					</#list>
				</tr>
				</#list>
			</tbody>
		</table>
		
	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/3.2.2/ekko-lightbox.min.js"></script>
	
	
	<script>
	$(document).ready(function() {
		$(document).delegate('*[data-toggle="lightbox"]', 'click', function(event) {
			event.preventDefault();
			return $(this).ekkoLightbox({
				onShown: function() {
					if (window.console) {
						return console.log('Checking our the events huh?');
					}
				},
				onNavigate: function(direction, itemIndex) {
					if (window.console) {
						return console.log('Navigating '+direction+'. Current item: '+itemIndex);
					}
				}
			});
		});
		
		$(".btn-radios .btn").click(function() {
				var str = $(this).attr("id").split("_");
				var idImageHide = str[0];
				var idImageShow = str[0] + "_" +  str[1];
								
				var mainObj = $(this).parent().parent().parent();

				mainObj.find("a[id^='" + idImageHide + "']").hide();
				mainObj.find("a[id^='" + idImageShow + "']").show();
		});
		
	});
	</script>
</body>
</html>


