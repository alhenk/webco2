window.onload = function () {
    var dataPoints = [{y : 0}, {y : 0}];

    var levels = [600, 680, 823, 900];
    //var levels = [[${readings}]];
    for(var i = 0; i < levels.length; i++){
        dataPoints.push({
            y : levels[i]
        });
    }

    var chart = new CanvasJS.Chart("chartContainer", {
            title : {
                text : "Dynamic Data"
            },
            data : [{
                    type : "spline",
                    dataPoints : dataPoints
                }
            ]
        });

    chart.render();

    var yVal = 15, updateCount = 0;
    var updateChart = function () {

        yVal = yVal + 500;//Math.round(5 + Math.random() * (-5 - 5));
          updateCount++;

        dataPoints.push({
            y : yVal
        });

        chart.options.title.text = "Update " + updateCount;
        chart.render();

    };

    // update chart every second
    setInterval(function(){updateChart()}, 1000);


}