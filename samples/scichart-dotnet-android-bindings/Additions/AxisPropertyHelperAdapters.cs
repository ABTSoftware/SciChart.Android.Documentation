using Com.Scichart.Charting3d.Visuals.Axes;

namespace Com.Scichart.Charting3d.Utility.PropertyHelpers {
    public partial class AxisPropertyHelper {
        protected override void Attach(global::Java.Lang.Object? target)
        {
            Attach(target as IAxis3D);
        }

        protected override void Detach(global::Java.Lang.Object? target)
        {
            Detach(target as IAxis3D);
        }
    }
}
