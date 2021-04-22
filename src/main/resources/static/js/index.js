const darkTheme = {
    chart: {
        layout: {
            backgroundColor: '#2B2B43',
            lineColor: '#2B2B43',
            textColor: '#D9D9D9',
        },
        watermark: {
            color: 'rgba(0, 0, 0, 0)',
        },
        crosshair: {
            color: '#758696',
        },
        grid: {
            vertLines: {
                color: '#2B2B43',
            },
            horzLines: {
                color: '#363C4E',
            },
        },
    },
    series: {
        topColor: 'rgba(32, 226, 47, 0.56)',
        bottomColor: 'rgba(32, 226, 47, 0.04)',
        lineColor: 'rgba(32, 226, 47, 1)',
    },
};

const chartElement = document.createElement('div');

const chart = LightweightCharts.createChart(chartElement, {
    width: 800,
    height: 250,
    rightPriceScale: {
        borderVisible: false,
    },
    timeScale: {
        borderVisible: false,
        timeVisible: true,
        secondsVisible: true,
    },
});


const areaSeries = chart.addAreaSeries({
    topColor: 'rgba(33, 150, 243, 0.56)',
    bottomColor: 'rgba(33, 150, 243, 0.04)',
    lineColor: 'rgba(33, 150, 243, 1)',
    lineWidth: 2,
});

chart.applyOptions(darkTheme.chart);
areaSeries.applyOptions(darkTheme.series);

document.getElementById("chart").append(chartElement);

function onSubmit(id) {
    const evtSource = new EventSource("/stream-transaction/currency/" + id);
    evtSource.onmessage = function (result) {
        const data = JSON.parse(result.data);
        const unixTime = Date.parse(new Date().toString())/1000;
        areaSeries.update({ time: unixTime, value: data.price });
    }
}
