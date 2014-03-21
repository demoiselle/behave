<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pt-br">
<head>
<title>testgrid-web - Login</title>
</head>
	<body marginheight="0" marginwidth="0" bottommargin="0" leftmargin="0" rightmargin="0" topmargin="0">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" background="./../../public/resources/images/logo-b.png" summary="Cabeçalho">
		<tr>
			<td align="left" >
				<img  alt="" src="./../../public/resources/images/logo-l.png"  alt="">				
			</td>			
		</tr>	
	</table>
	<form method="post" action="j_security_check" >
		<br/>
		<table align="center">
			<tr>
				<td>
					<label for="txt_username">Login:</label>
				</td>
				<td>
					<input id="txt_username" type="text" name="j_username" tabindex="1" title="Informe o usuário"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="txt_password">Senha:</label>
				</td>
				<td>
					<input id="txt_password" type="password" name= "j_password" tabindex="2" title="Informe a senha do usuário"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="login" tabindex="3" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<a href="">CVS Usuários</a>
				</td>
			</tr>			
		</table>
	</form>
</body>
</html>