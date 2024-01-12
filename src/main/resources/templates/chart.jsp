<!-- chart.jsp-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        window.onload = function() {

            var dataPoints = [];
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2", // "light1", "dark1", "dark2"
                title: {
                    text: "Room Temperature"
                },
                axisX: {
                    title: "Time Elapsed (in seconds)",
                    suffix: " s"
                },
                axisY: {
                    title: "Temperature (in °C)",
                    valueFormatString: "#,##0.0",
                    suffix: " °C"
                },
                data: [{
                    type: "line",
                    xValueFormatString: "After #,##0 s",
                    yValueFormatString: "#,##0.0 °C",
                    dataPoints: dataPoints
                }]
            });

            var yValue;
            var xValue;
            var updateInterval = 2000;

            <c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
            <c:forEach items="${dataPoints}" var="dataPoint">
            yValue = parseFloat("${dataPoint.y}");
            xValue = parseInt("${dataPoint.x}");
            dataPoints.push({
                x : xValue,
                y : yValue,
            });
            </c:forEach>
            </c:forEach>

            chart.render();

            setInterval(function () { updateChart() }, updateInterval);

            function updateChart(count) {
                count = count || 1;
                for (var i = 0; i < count; i++) {
                    xValue += 2;
                    yValue = Math.max(yValue + (0.2 + Math.random() * (-0.2 - 0.2)), 0);
                    dataPoints.push({ x: xValue, y: yValue });
                }
                chart.render();
            }

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
</body>
</html>