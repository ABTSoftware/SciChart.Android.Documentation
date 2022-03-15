using System;
using Android.App;
using Android.OS;
using Android.Views;
using AndroidX.AppCompat.App;
using SciChart.Core.Framework;
using SciChart.Charting.Visuals;
using SciChart.Charting.Visuals.Axes;
using SciChart.Charting.Model.DataSeries;
using SciChart.Charting.Visuals.RenderableSeries;
using SciChart.Charting.Visuals.PointMarkers;
using SciChart.Drawing.Common;
using SciChart.Charting.Modifiers;
using System.Timers;
using SciChart.Core.Model;

namespace Tutorial_2d_04
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        private readonly object _syncRoot = new object();

        // <DataSeriesSetup>
        private const int PointsCount = 200;
        private const long TimerInterval = 10;

        private Timer _timer;

        private SciChartSurface surface;

        private readonly DoubleValues lineData = new DoubleValues();
        private readonly XyDataSeries<int, double> lineDataSeries = new XyDataSeries<int, double>() { SeriesName = "Line Series" };

        private readonly DoubleValues scatterData = new DoubleValues();
        private readonly XyDataSeries<int, double> scatterDataSeries = new XyDataSeries<int, double>() { SeriesName = "Scatter Series" };
        // </DataSeriesSetup>

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);

            SciChartSurface.SetRuntimeLicenseKey("");
            SetContentView(Resource.Layout.activity_main);

            surface = new SciChartSurface(this);
            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);
            chartLayout.AddView(surface);

            // <SetFifoCapacity>
            lineDataSeries.FifoCapacityValue = 300;
            scatterDataSeries.FifoCapacityValue = 300;
            // </SetFifoCapacity>

            // <InitialDataSetup>
            var xValues = new IntegerValues();

            for (int i = 0; i < PointsCount; i++) 
            {
                xValues.Add(i);
                lineData.Add(Math.Sin(i * 0.1));
                scatterData.Add(Math.Cos(i * 0.1));
                count += 1;
            }  
            lineDataSeries.Append(xValues, lineData);
            scatterDataSeries.Append(xValues, scatterData);
            // </InitialDataSetup>

            var lineSeries = new FastLineRenderableSeries() { DataSeries = lineDataSeries };
            var scatterSeries = new XyScatterRenderableSeries()
            {
                DataSeries = scatterDataSeries,
                PointMarker = new EllipsePointMarker()
                {
                    Width = 10,
                    Height = 10,
                    FillStyle = new SolidBrushStyle(0xFF32CD32)
                }
            };

            // <CreateLegend>
            var legendModifier = new LegendModifier(this);
            legendModifier.SetOrientation(Orientation.Horizontal);
            legendModifier.SetLegendPosition(GravityFlags.Bottom | GravityFlags.CenterHorizontal, 0, 0, 0, 10);
            // </CreateLegend>

            using (surface.SuspendUpdates())
            {
                surface.XAxes.Add(new NumericAxis(this) { AxisTitle = "X Axis Title" } );
                surface.YAxes.Add(new NumericAxis(this) { AxisTitle = "Y Axis Title" } );

                surface.RenderableSeries.Add(lineSeries);
                surface.RenderableSeries.Add(scatterSeries);

                surface.ChartModifiers.Add(new PinchZoomModifier());
                surface.ChartModifiers.Add(new ZoomPanModifier());
                surface.ChartModifiers.Add(new ZoomExtentsModifier());
                surface.ChartModifiers.Add(legendModifier);
                surface.ChartModifiers.Add(new RolloverModifier());
            }

            // <CreateTimer>
            _timer = new Timer(TimerInterval) { AutoReset = true };
            _timer.Elapsed += OnTick;
            _timer.Start();
            // </CreateTimer>
        }

        // <AppendData>
        private int count = 0;

        private void OnTick(object sender, ElapsedEventArgs e)
        {
            lock (_syncRoot)
            {
                var x = count;
                using (surface.SuspendUpdates())
                {
                    lineDataSeries.Append(x, Math.Sin(x * 0.1));
                    scatterDataSeries.Append(x, Math.Cos(x * 0.1));

                    count += 1;
                    surface.ZoomExtentsX();
                }
            }
        }
        // </AppendData>

        /*
        // <UpdateData>
        private Double phase = 0.0;

        private void OnTick(object sender, ElapsedEventArgs e)
        {
            lock (_syncRoot)
            {
                for (int i = 0; i < PointsCount; i++)
                {
                    lineData.Set(i, Math.Sin(i * 0.1 + phase));
                    scatterData.Set(i, Math.Cos(i * 0.1 + phase));
                }
                
                using (surface.SuspendUpdates())
                {
                    lineDataSeries.UpdateRangeYAt(0, lineData);
                    scatterDataSeries.UpdateRangeYAt(0, scatterData);

                    // zoom series to fit viewport size into X-Axis direction
                    surface.ZoomExtentsX();
                }

                phase += 0.01;
            }
        }
        // </UpdateData>
        */
	}
}