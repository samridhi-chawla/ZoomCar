
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js" type="text/javascript"></script>-->
        <script src="../js/Chart.min.js" type="text/javascript"></script>
        <!--        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
                <link href="../css/css.css" rel="stylesheet" type="text/css"/>
                <script src="../js/jquery-3.2.0.min.js" type="text/javascript"></script>
                <script src="../js/chart.js" type="text/javascript"></script>
                <script src="../js/bootstrap.min.js" type="text/javascript"></script>-->
    <body>
        <div style="width: 400px;height: 400px">
        <canvas id="myChart" width="100" height="100"></canvas>
        </div>
<script>
var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],  //x axis
        datasets: [{
            label: '# of Votes',           //appear on top of chart
            data: [12, 19, 3, 5, 2, 3],   //y axis
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
</script>
    </body>
</html>
