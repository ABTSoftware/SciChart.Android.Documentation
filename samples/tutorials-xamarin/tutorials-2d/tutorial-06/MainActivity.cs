﻿using System;
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
using SciChart.Charting.Visuals.Annotations;
using SciChart.Data.Model;

namespace Tutorial_2d_06
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        private readonly object _syncRoot = new object();

        private const int FifoCapacity = 300;
        private const int PointsCount = 200;
        private const long TimerInterval = 10;

        private SciChartSurface surface;
        private Timer _timer;
        private int count = 0;

        private readonly DoubleValues lineData = new DoubleValues();
        private readonly XyDataSeries<int, double> lineDataSeries = new XyDataSeries<int, double>() 
        {
            SeriesName = "Line Series", 
            FifoCapacityValue = FifoCapacity 
        };

        private readonly DoubleValues scatterData = new DoubleValues();
        private readonly XyDataSeries<int, double> scatterDataSeries = new XyDataSeries<int, double>() 
        { 
            SeriesName = "Scatter Series", 
            FifoCapacityValue = FifoCapacity 
        };

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);

            SciChartSurface.SetRuntimeLicenseKey("");
            SetContentView(Resource.Layout.activity_main);

            surface = new SciChartSurface(this);
            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);
            chartLayout.AddView(surface);

            // <CreateMultipleAxes>
            // Create another numeric axis, right-aligned
            var yAxisRight = new NumericAxis(this)
            {
                AxisTitle = "Primary Y-Axis",
                AxisId = "Primary Y-Axis",
                AxisAlignment = AxisAlignment.Right
            };

            // Create another numeric axis, left-aligned
            var yAxisLeft = new NumericAxis(this)
            {
                AxisTitle = "Secondary Y-Axis",
                AxisId = "Secondary Y-Axis",
                AxisAlignment = AxisAlignment.Left,
                GrowBy = new DoubleRange(0.2, 0.2)
            };
            // </CreateMultipleAxes>

            using (surface.SuspendUpdates())
            {
                // <AddMultipleAxes>
                surface.XAxes.Add(new NumericAxis(this));
                surface.YAxes.Add(yAxisLeft);
                surface.YAxes.Add(yAxisRight);
                // </AddMultipleAxes>
            }

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

            // <AttachSeriesToAxes1>
            var lineSeries = new FastLineRenderableSeries();
            lineSeries.YAxisId = "Primary Y-Axis";
            // </AttachSeriesToAxes1>
            lineSeries.DataSeries = lineDataSeries;

            // <AttachSeriesToAxes2>
            var scatterSeries = new XyScatterRenderableSeries();
            scatterSeries.YAxisId = "Secondary Y-Axis";
            // </AttachSeriesToAxes2>
            scatterSeries.DataSeries = scatterDataSeries;
            scatterSeries.PointMarker = new EllipsePointMarker()
            {
                Width = 10,
                Height = 10,
                FillStyle = new SolidBrushStyle(0xFF32CD32)
            };

            var legendModifier = new LegendModifier(this);
            legendModifier.SetOrientation(Orientation.Horizontal);
            legendModifier.SetLegendPosition(GravityFlags.Bottom | GravityFlags.CenterHorizontal, 0, 0, 0, 10);

            using (surface.SuspendUpdates())
            {
                surface.RenderableSeries.Add(lineSeries);
                surface.RenderableSeries.Add(scatterSeries);

                surface.ChartModifiers.Add(new PinchZoomModifier());
                surface.ChartModifiers.Add(new ZoomPanModifier());
                surface.ChartModifiers.Add(new ZoomExtentsModifier());
                surface.ChartModifiers.Add(legendModifier);
                surface.ChartModifiers.Add(new RolloverModifier());

                // <AddYAxisDragModifier>
                surface.ChartModifiers.Add(new YAxisDragModifier());
                // </AddYAxisDragModifier>
            }

            _timer = new Timer(TimerInterval) { AutoReset = true };
            _timer.Elapsed += OnTick;
            _timer.Start();
        }

        private void OnTick(object sender, ElapsedEventArgs e)
        {
            lock (_syncRoot)
            {
                var x = count;
                using (surface.SuspendUpdates())
                {
                    lineDataSeries.Append(x, Math.Sin(x * 0.1));
                    scatterDataSeries.Append(x, Math.Cos(x * 0.1));

                    TryAddAnnotationAt(x);

                    count += 1;
                    surface.ZoomExtentsX();
                }
            }
        }

        private void TryAddAnnotationAt(int x)
        {
            if (x % 100 == 0)
            {
                // <AttachAnnotationsToAxes>
                var label = new TextAnnotation(this);
                label.YAxisId = x % 200 == 0 ? "Primary Y-Axis" : "Secondary Y-Axis";
                // </AttachAnnotationsToAxes>
                label.Text = "N";
                label.X1Value = x;
                label.Y1Value = 0;
                label.HorizontalAnchorPoint = HorizontalAnchorPoint.Center;
                label.VerticalAnchorPoint = VerticalAnchorPoint.Center;
                label.FontStyle = new FontStyle(30f, 0xFFFFFFFF);


                // add label into annotation collection
                surface.Annotations.Add(label);

                // if we add annotation and x > fifoCapacity
                // then we need to remove annotation which goes out of the screen
                if (x > FifoCapacity)
                {
                    surface.Annotations.RemoveAt(0);
                }
            }
        }
	}
}