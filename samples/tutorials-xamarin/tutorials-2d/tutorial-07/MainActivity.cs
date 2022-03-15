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
using SciChart.Charting.Visuals.Annotations;
using SciChart.Data.Model;
using Android.Widget;
using SciChart.Charting.Visuals.Rendering;

namespace Tutorial_2d_07
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        private readonly object _syncRoot = new object();

        private const int FifoCapacity = 300;
        private const int PointsCount = 200;
        private const long TimerInterval = 10;

        private SciChartSurface surface1;
        private SciChartSurface surface2;
        private Timer _timer;
        private int count = 0;

        private readonly XyDataSeries<int, double> lineDataSeries = new XyDataSeries<int, double>() 
        {
            SeriesName = "Line Series", 
            FifoCapacityValue = FifoCapacity 
        };

        private readonly XyDataSeries<int, double> scatterDataSeries = new XyDataSeries<int, double>() 
        { 
            SeriesName = "Scatter Series", 
            FifoCapacityValue = FifoCapacity 
        };

        private readonly XyDataSeries<int, double> mountainDataSeries = new XyDataSeries<int, double>() 
        { 
            SeriesName = "Mountain Series", 
            FifoCapacityValue = FifoCapacity 
        };

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);

            SciChartSurface.SetRuntimeLicenseKey("");
            SetContentView(Resource.Layout.activity_main);

            var chartLayout = FindViewById<ViewGroup>(Resource.Id.chart_layout);

            // <AddTwoSurfaces>
            surface1 = new SciChartSurface(this);
            surface2 = new SciChartSurface(this);
            chartLayout.AddView(surface1);
            chartLayout.AddView(surface2);

            // Set layout parameters for both surfaces
            var layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MatchParent,
                ViewGroup.LayoutParams.MatchParent,
                1.0f
            );
            surface1.LayoutParameters = layoutParams;
            surface2.LayoutParameters = layoutParams;
            // </AddTwoSurfaces>

            var xValues = new IntegerValues();
            for (int i = 0; i < PointsCount; i++) 
            {
                lineDataSeries.Append(i, Math.Sin(i * 0.1));
                scatterDataSeries.Append(i, Math.Cos(i * 0.1));
                mountainDataSeries.Append(i, Math.Cos(i * 0.1));
                count += 1;
            }  
            
            var lineSeries = new FastLineRenderableSeries() { 
                YAxisId = "Primary Y-Axis", 
                DataSeries = lineDataSeries 
            };
            var scatterSeries = new XyScatterRenderableSeries()
            {
                YAxisId = "Secondary Y-Axis",
                DataSeries = scatterDataSeries,
                PointMarker = new EllipsePointMarker()
                {
                    Width = 10,
                    Height = 10,
                    FillStyle = new SolidBrushStyle(0xFF32CD32)
                }
            };

            using (surface1.SuspendUpdates())
            {
                surface1.RenderableSeries.Add(lineSeries);
                surface1.RenderableSeries.Add(scatterSeries);
            }

            // <AddMountainSeries>
            var mountainSeries = new FastMountainRenderableSeries() 
            {
                YAxisId = "Primary Y-Axis",
                DataSeries = mountainDataSeries,
                StrokeStyle = new SolidPenStyle(0xFF0271B1, 1.0f, false, null),
                AreaStyle = new SolidBrushStyle(0xAAFF8D42)
            };

            using (surface2.SuspendUpdates())
            {
                surface2.RenderableSeries.Add(mountainSeries);
            }
            // </AddMountainSeries>

            // <SetupSurfaces2>
            SetupSurface(surface1);
            SetupSurface(surface2);
            // </SetupSurfaces2>

            _timer = new Timer(TimerInterval) { AutoReset = true };
            _timer.Elapsed += OnTick;
            _timer.Start();
        }

        // <SetupSurfaces1>
        private void SetupSurface(SciChartSurface surface)
        {
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

            var rolloverModifier = new RolloverModifier() 
            {
                ReceiveHandledEvents = true,
                EventsGroupTag = "SharedEventGroup"
            };

            using (surface.SuspendUpdates())
            {
                surface.XAxes.Add(new NumericAxis(this));
                surface.YAxes.Add(yAxisLeft);
                surface.YAxes.Add(yAxisRight);

                surface.ChartModifiers.Add(new ZoomExtentsModifier());
                surface.ChartModifiers.Add(new PinchZoomModifier());
                surface.ChartModifiers.Add(rolloverModifier);

                surface.ChartModifiers.Add(new XAxisDragModifier());
                surface.ChartModifiers.Add(new YAxisDragModifier());
            }
        }
        // </SetupSurfaces1>

        /*
            // <SynchronizeVisibleRanges>
            // Create an IRange instance that will be shared across multiple charts
            var sharedXRange = new DoubleRange();

            // Create an X axis and apply sharedXRange
            var xAxis1 = new NumericAxis(this) { VisibleRange = sharedXRange };
            // Create another X axis and apply sharedXRange
            var xAxis2 = new NumericAxis(this) { VisibleRange = sharedXRange };
            // </SynchronizeVisibleRanges>


            // <AddVerticalGroup>
            var verticalGroup = new SciChartVerticalGroup();
            verticalGroup.AddSurfaceToGroup(surface1);
            verticalGroup.AddSurfaceToGroup(surface2);
            // </AddVerticalGroup>


            // <SetModifierGroup>
            var modifierGroup = new ModifierGroup()
            {
                MotionEventGroup = "SharedEventGroup",
                ReceiveHandledEvents = true 
            };
            modifierGroup.ChildModifiers.Add(new ZoomExtentsModifier());
            modifierGroup.ChildModifiers.Add(new PinchZoomModifier());
            modifierGroup.ChildModifiers.Add(rolloverModifier);
            modifierGroup.ChildModifiers.Add(new XAxisDragModifier());
            modifierGroup.ChildModifiers.Add(new YAxisDragModifier());
            // </SetModifierGroup>
        */

        private void OnTick(object sender, ElapsedEventArgs e)
        {
            lock (_syncRoot)
            {
                var x = count;
                using (surface1.SuspendUpdates())
                {
                    lineDataSeries.Append(x, Math.Sin(x * 0.1));
                    scatterDataSeries.Append(x, Math.Cos(x * 0.1));
                    mountainDataSeries.Append(x, Math.Cos(x * 0.1));

                    TryAddAnnotationAt(x);

                    count += 1;
                    surface1.ZoomExtentsX();
                    surface2.ZoomExtentsX();
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
                surface1.Annotations.Add(label);

                // if we add annotation and x > fifoCapacity
                // then we need to remove annotation which goes out of the screen
                if (x > FifoCapacity)
                {
                    surface1.Annotations.RemoveAt(0);
                }
            }
        }
	}
}