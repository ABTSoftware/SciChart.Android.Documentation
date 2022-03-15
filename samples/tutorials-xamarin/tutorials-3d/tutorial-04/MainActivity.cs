using System;
using System.Timers;
using Android.App;
using Android.Graphics;
using Android.OS;
using Android.Views;
using AndroidX.AppCompat.App;
using SciChart.Charting.Visuals;
using SciChart.Charting3D.Model.DataSeries.Xyz;
using SciChart.Charting3D.Modifiers;
using SciChart.Charting3D.Visuals;
using SciChart.Charting3D.Visuals.Axes;
using SciChart.Charting3D.Visuals.PointMarkers;
using SciChart.Charting3D.Visuals.RenderableSeries.Scatter;
using SciChart.Core.Model;

namespace Tutorial_3d_04
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        private readonly object _syncRoot = new object();

        // <DataSeriesSetup>
        private const int PointsCount = 200;
        private const long TimerInterval = 10;

        private Timer _timer;

        private SciChartSurface3D surface;

        private readonly DoubleValues xValues = new DoubleValues();
        private readonly DoubleValues yValues = new DoubleValues();
        private readonly DoubleValues zValues = new DoubleValues();
    
        private readonly XyzDataSeries3D<double, double, double> dataSeries = new XyzDataSeries3D<double, double, double>();
        // </DataSeriesSetup>

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);

            SciChartSurface.SetRuntimeLicenseKey("");
            SetContentView(Resource.Layout.activity_main);

            surface = new SciChartSurface3D(this);
            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);
            chartLayout.AddView(surface);

            // <AppendDataSeries>
            for (int i = 0; i < PointsCount; i++)
            {
                xValues.Add(GetGaussianRandomNumber(5.0, 1.5));
                yValues.Add(GetGaussianRandomNumber(5.0, 1.5));
                zValues.Add(GetGaussianRandomNumber(5.0, 1.5));
            }
            dataSeries.Append(xValues, yValues, zValues);
            // </AppendDataSeries>

            var rSeries = new ScatterRenderableSeries3D()
            {
                DataSeries = dataSeries,
                PointMarker = new SpherePointMarker3D()
                {
                    Fill = new Color(0x32, 0xCD, 0x32, 0xFF),
                    Size = 10
                }
            };

            using (surface.SuspendUpdates())
            {
                surface.XAxis = new NumericAxis3D();
                surface.YAxis = new NumericAxis3D();
                surface.ZAxis = new NumericAxis3D();

                surface.RenderableSeries.Add(rSeries);

                // <AddModifiers>
                surface.ChartModifiers.Add(new OrbitModifier3D { ExecuteOnPointerCount = 2 });
                surface.ChartModifiers.Add(new ZoomExtentsModifier3D());
                surface.ChartModifiers.Add(new PinchZoomModifier3D());
                surface.ChartModifiers.Add(new TooltipModifier3D { CrosshairMode = CrosshairMode.Lines });
                // </AddModifiers>
            }

            // <CreateTimer>
            _timer = new Timer(TimerInterval) { AutoReset = true };
            _timer.Elapsed += OnTick;
            _timer.Start();
            // </CreateTimer>
        }   

        // <UpdateData>
        private Random _random = new Random();

        private void OnTick(object sender, ElapsedEventArgs e)
        {
            lock (_syncRoot)
            {
                for (int i = 0; i < PointsCount; i++)
                {
                    var xValue = xValues.Get(i) + _random.NextDouble() - 0.5;
                    var yValue = yValues.Get(i) + _random.NextDouble() - 0.5;
                    var zValue = zValues.Get(i) + _random.NextDouble() - 0.5;

                    xValues.Set(i, xValue);
                    yValues.Set(i, yValue);
                    zValues.Set(i, zValue);
                }

                using (surface.SuspendUpdates())
                {
                    dataSeries.UpdateRangeXyzAt(0, xValues, yValues, zValues);
                }
            }
        }
        // </UpdateData>

        private double GetGaussianRandomNumber(double mean, double stdDev)
        {
            var random = new Random();

            double u1 = random.NextDouble();
            double u2 = random.NextDouble();

            var randStdNormal = Math.Sqrt(-2.0 * Math.Log10(u1)) * Math.Sin(2.0 * Math.PI * u2);
            return mean * stdDev * randStdNormal;
        }
    }
}