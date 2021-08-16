<!DOCTYPE html>
<html>
    <head>
        <title>Cellphone usage report</title>
        <style>
            body{background-color: white; font-family: Arial; font-size: 12px}
            h1{color: blue;}
            .header{
                border: 1px dotted;
                padding: 10px;
            }
            .table{
                width: 90%;
            }

        </style>
    </head>
    <body>
        <div>
            <h1>Cell phone usage report</h1>
        </div>
        <div class="header">
            <ul>
                <li>Report Run Date: ${runDate}</li>
            </ul>
            <ul>
                <li>Number of phones: ${numberOfPhones}</li>
            </ul>
            <ul>
                <li>Total minutes: ${totalMinutes}</li>
            </ul>
            <ul>
                <li>Total data: ${totalData}</li>
            </ul>
            <ul>
                <li>Average minutes: ${averageMinutes}</li>
            </ul>
            <ul>
                <li>Average data: ${averageData}</li>
            </ul>
        </div>

        <div>
            <table class="table">
                    <tr>
                        <td>Employee Id</td>
                        <td>Employee Name</td>
                        <td>Model</td>
                        <td>Purchase Date</td>
                        <td>Minutes usage by month</td>
                        <td>Data usage by month</td>
                    </tr>
                <tbody>
                <#list details as detail>
                    <tr>
                        <td>${detail.employeeId}</td>
                        <td>${detail.employeeName}</td>
                        <td>${detail.model}</td>
                        <td>${detail.purchaseDate}</td>
                        <td>
                            <table border="1">
                                <thead>
<#--                                <#list detail.minutesByMonth as minutesByMonth>-->

                                    <tr>
                                        <#list 1..detail.minutesByMonth?size as i>
                                        <th>${i}</th>
                                        </#list>
                                    </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <#list 0..detail.minutesByMonth?size-1 as index>
                                        <th>${detail.minutesByMonth[index]}</th>
                                    </#list>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>
                            <table border="1">
                                <thead>

                                <tr>
                                    <#list 1..detail.dataByMonth?size as i>
                                        <th>${i}</th>
                                    </#list>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <#list 0..detail.dataByMonth?size-1 as index>
                                        <th>${detail.dataByMonth[index]}</th>
                                    </#list>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </body>
</html>


