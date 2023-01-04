window.addEventListener('load', function() {
    const userData = document.querySelector('#dataFromUser');

    console.log(userData.dataset);

    let budget = userData.dataset.budget;
    let totalDistance = userData.dataset.distance;
    let gasTank = userData.dataset.gasTank;
    let mpg = userData.dataset.mpg;
    let otherExpenses = userData.dataset.otherExpenses;
    let perGallon = userData.dataset.perGallon;

    // code to be executed when the window is loaded

        var totalVisitors = 883000;
        var visitorsData = {
            "New vs Returning Visitors": [{
                click: visitorsChartDrilldownHandler,
                cursor: "pointer",
                explodeOnClick: false,
                innerRadius: "75%",
                legendMarkerType: "square",
                name: "Your trip to: ",
                radius: "100%",
                showInLegend: true,
                startAngle: 90,
                type: "doughnut",
                dataPoints: [
                    { y: 519960, name: "New Visitors", color: "#E7823A" },
                    { y: 363040, name: "Returning Visitors", color: "#546BC1" }
                ]
            }],
            "New Visitors": [{
                color: "#E7823A",
                name: "New Visitors",
                type: "column",
                dataPoints: [
                    { x: new Date("1 Jan 2015"), y: 33000 },
                    { x: new Date("1 Feb 2015"), y: 35960 },
                    { x: new Date("1 Mar 2015"), y: 42160 },
                    { x: new Date("1 Apr 2015"), y: 42240 },
                    { x: new Date("1 May 2015"), y: 43200 },
                    { x: new Date("1 Jun 2015"), y: 40600 },
                    { x: new Date("1 Jul 2015"), y: 42560 },
                    { x: new Date("1 Aug 2015"), y: 44280 },
                    { x: new Date("1 Sep 2015"), y: 44800 },
                    { x: new Date("1 Oct 2015"), y: 48720 },
                    { x: new Date("1 Nov 2015"), y: 50840 },
                    { x: new Date("1 Dec 2015"), y: 51600 }
                ]
            }],
            "Returning Visitors": [{
                color: "#546BC1",
                name: "Returning Visitors",
                type: "column",
                dataPoints: [
                    { x: new Date("1 Jan 2015"), y: 22000 },
                    { x: new Date("1 Feb 2015"), y: 26040 },
                    { x: new Date("1 Mar 2015"), y: 25840 },
                    { x: new Date("1 Apr 2015"), y: 23760 },
                    { x: new Date("1 May 2015"), y: 28800 },
                    { x: new Date("1 Jun 2015"), y: 29400 },
                    { x: new Date("1 Jul 2015"), y: 33440 },
                    { x: new Date("1 Aug 2015"), y: 37720 },
                    { x: new Date("1 Sep 2015"), y: 35200 },
                    { x: new Date("1 Oct 2015"), y: 35280 },
                    { x: new Date("1 Nov 2015"), y: 31160 },
                    { x: new Date("1 Dec 2015"), y: 34400 }
                ]
            }]
        };

        var newVSReturningVisitorsOptions = {
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
                    return e.dataPoint.name + ": " + Math.round(e.dataPoint.y / totalVisitors * 100) + "%";
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

        var chart = new CanvasJS.Chart("chartContainer", newVSReturningVisitorsOptions);
        chart.options.data = visitorsData["New vs Returning Visitors"];
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
            chart = new CanvasJS.Chart("chartContainer", newVSReturningVisitorsOptions);
            chart.options.data = visitorsData["New vs Returning Visitors"];
            chart.render();
        });

});
