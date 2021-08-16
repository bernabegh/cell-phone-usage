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
    </body>
</html>


