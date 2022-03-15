using System;
using Android.App;
using Android.Graphics;
using Android.OS;
using Android.Views;
using AndroidX.AppCompat.App;
using SciChart.Charting.Visuals;
using SciChart.Charting3D.Model.DataSeries.Xyz;
using SciChart.Charting3D.Visuals;
using SciChart.Charting3D.Visuals.Axes;
using SciChart.Charting3D.Visuals.PointMarkers;
using SciChart.Charting3D.Visuals.RenderableSeries.Scatter;

namespace Tutorial_3d_01
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);

            SciChartSurface.SetRuntimeLicenseKey("");
            SetContentView(Resource.Layout.activity_main);

            var surface = new SciChartSurface3D(this);
            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);
            chartLayout.AddView(surface);

            // <CreateDataSeries>
            var dataSeries = new XyzDataSeries3D<double, double, double>();
            for (int i = 0; i < 200; i++)
            {
                var x = GetGaussianRandomNumber(5.0, 1.5);
                var y = GetGaussianRandomNumber(5.0, 1.5);
                var z = GetGaussianRandomNumber(5.0, 1.5);
                dataSeries.Append(x, y, z);
            }
            // </CreateDataSeries>

            // <CreateRenderableSeries>
            var rSeries = new ScatterRenderableSeries3D()
            {
                DataSeries = dataSeries,
                PointMarker = new SpherePointMarker3D()
                {
                    Fill = new Color(0x32, 0xCD, 0x32, 0xFF),
                    Size = 10
                }
            };
            // </CreateRenderableSeries>

            using (surface.SuspendUpdates())
            {
                // <AddAxes>
                surface.XAxis = new NumericAxis3D();
                surface.YAxis = new NumericAxis3D();
                surface.ZAxis = new NumericAxis3D();
                // </AddAxes>

                // <AddRenderableSeries>
                surface.RenderableSeries.Add(rSeries);
                // </AddRenderableSeries>
            }
        }   

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