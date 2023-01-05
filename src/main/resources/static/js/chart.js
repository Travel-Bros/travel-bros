window.addEventListener('load', function() {
    const userData = document.querySelector('#dataFromUser');

    console.log(userData.dataset);

    let budget = parseInt(userData.dataset.budget);
    let gas = parseInt(userData.dataset.gas);
    let otherExpenses = parseInt(userData.dataset.miscExpense);
    let cashLeftOver = budget - (gas + otherExpenses);
    console.log(gas);

    // code to be executed when the window is loaded

        var totalBudget = budget;
        var visitorsData = {
            "Your trip": [{
                click: visitorsChartDrilldownHandler,
                cursor: "pointer",
                explodeOnClick: false,
                innerRadius: "90%",
                legendMarkerType: "square",
                name: "Your trip to: ",
                radius: "100%",
                showInLegend: true,
                startAngle: 90,
                type: "doughnut",
                dataPoints: [
                    // { y: `${budget}`, name: "Budget", color: "#E7823A" },
                    { y: `${gas}`, name: "gas", color: "#8DD6C0" },
                    { y: `${otherExpenses}`, name: "otherExpenses", color: "#EE8584" },
                    { y: `${cashLeftOver}`, name: "cashLeftOver", color: "#9C7DC8" }
                ]
            }],
        };

        var finalTrip = {
            animationEnabled: true,
            theme: "light2",
            title: {
                text: `Your trip to: `
            },
            // subtitles: [{
            //     text: "Click on Any Segment to Drilldown",
            //     backgroundColor: "#2eacd1",
            //     fontSize: 16,
            //     fontColor: "white",
            //     padding: 5
            // }],
            legend: {
                fontFamily: "calibri",
                fontSize: 14,
                itemTextFormatter: function (e) {
                    return e.dataPoint.name + ": " + Math.round(e.dataPoint.y / totalBudget  * 100) + "%";
                }
            },
            data: []
        };

        var visitorsDrilldownedChartOptions = {
            animationEnabled: true,
            theme: "light2",
            axisX: {
                labelFontColor: "#717171",
                lineColor: "#a2a2a2",
                tickColor: "#a2a2a2"

            },
            axisY: {
                gridThickness: 0,
                includeZero: false,
                labelFontColor: "#717171",
                lineColor: "#a2a2a2",
                tickColor: "#a2a2a2",
                lineThickness: 1
            },
            data: []
        };

        var chart = new CanvasJS.Chart("chartContainer", finalTrip);
        chart.options.data = visitorsData["Your trip"];
        chart.render();

        function visitorsChartDrilldownHandler(e) {
            chart = new CanvasJS.Chart("chartContainer", visitorsDrilldownedChartOptions);
            chart.options.data = visitorsData[e.dataPoint.name];
            chart.options.title = { text: e.dataPoint.name }
            chart.render();
            $("#backButton").toggleClass("invisible");
        }

        $("#backButton").click(function() {
            $(this).toggleClass("invisible");
            chart = new CanvasJS.Chart("chartContainer", finalTrip);
            chart.options.data = visitorsData["Your trip"];
            chart.render();
        });

});
