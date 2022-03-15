using System;
using Android.App;
using Android.OS;
using Android.Views;
using AndroidX.AppCompat.App;
using SciChart.Charting.Model.DataSeries;
using SciChart.Charting.Visuals;
using SciChart.Charting.Visuals.Axes;
using SciChart.Charting.Visuals.PointMarkers;
using SciChart.Charting.Visuals.RenderableSeries;
using SciChart.Drawing.Common;

namespace Tutorial_2d_01
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

            var surface = new SciChartSurface(this);
            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);
            chartLayout.AddView(surface);

            // <AddingAxesToTheSciChartSurface>
            var xAxis = new NumericAxis(this);
            var yAxis = new NumericAxis(this);

            using (surface.SuspendUpdates())
            {
                surface.XAxes.Add(xAxis);
                surface.YAxes.Add(yAxis);
            }
            // </AddingAxesToTheSciChartSurface>

            // <DeclareDataSeries>
            var lineDataSeries = new XyDataSeries<int, double>();
            var scatterDataSeries = new XyDataSeries<int, double>();

            for (int i = 0; i < 999; i++)
            {
                lineDataSeries.Append(i, Math.Sin(i * 0.1));
                scatterDataSeries.Append(i, Math.Cos(i * 0.1));
            }
            // </DeclareDataSeries>

            // <CreateRenderableSeries>
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
            // </CreateRenderableSeries>

            // <AddRenderableSeries>
            using (surface.SuspendUpdates())
            {
                surface.RenderableSeries.Add(lineSeries);
                surface.RenderableSeries.Add(scatterSeries);
            }
            // </AddRenderableSeries>
        }
    }
}