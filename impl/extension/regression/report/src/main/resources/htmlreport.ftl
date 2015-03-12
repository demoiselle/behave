<!DOCTYPE html>
<head>
   <title>Image Comparison report</title>
       <style type="text/css">
       	   * {
       	   		font-size: 11px;
       	   }
           body {
               font-family: Arial;
           }

           table, th, td {
               border: 1px solid #000000;
           }

           .ok {
               background-color: #DFFFA5;
           }

           .slight {
                background-color: #FFFACD;
           }

           .warning {
                background-color: #FFE4E1;
           }

           .bigdeviation {
                background-color: #FF3333
           }
       </style>

</head>

<body>
    <h3>Legend:</h3>
      <p class="ok">No (0%) pixel deviation</p>
      <p class="slight">&gt; 0% and &lt;=10% pixel deviation</p>
      <p class="warning">&gt;10% and &lt;=20% pixel deviation</p>
      <p class="bigdeviation">&gt;20 % pixel deviation</p>

    <table id="results">
        <thead>
            <tr>
                <#list columnHeaders as columnHeader>
                    <th>${columnHeader}</th>
                </#list>
            </tr>
        </thead>
        <tbody>
            <#list resultRows as resultRow>
                <#assign deviation=resultRow.getPercentageDeviation()>
                <#if deviation == 0>
                    <tr class="ok">
                <#elseif (deviation > 0) && deviation <= 10>
                    <tr class="slight">
                <#elseif (deviation > 10) && deviation <= 20>
                    <tr class="warning">
                <#elseif (deviation > 20)>
                    <tr class="bigdeviation">
                </#if>
                    <td><a href="./${resultRow.getReportFileName()}/${resultRow.getExpectedFileName()}" target="_blank"><img src="${resultRow.getExpectedFileName()}" width="300"/></a> ${resultRow.getExpectedFileName()}</td>
                    <td>${resultRow.getActualFileName()}</td>
                    <td>${resultRow.getExpectedTotalPixels()}</td>
                    <td>${resultRow.getActualTotalPixels()}</td>
                    <td>${resultRow.getOutput()}</td>
                    <td>${resultRow.getPercentageDeviation()}</td>
                    <td>${resultRow.getStrategyUsed().getValue()}</td>
                    <td>${resultRow.getNotes()!""}</td>
                    <td>${resultRow.getCommandExecuted()}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>