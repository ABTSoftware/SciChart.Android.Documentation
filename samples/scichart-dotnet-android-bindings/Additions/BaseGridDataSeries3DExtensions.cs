using Android.Runtime;

namespace Com.Scichart.Charting3d.Model.DataSeries.Grid {
    public abstract partial class BaseGridDataSeries3D {
        [Register("getXValueAt", "(I)Ljava/lang/Comparable;", "GetGetXValueAt_IHandler")]
        public abstract global::Java.Lang.Object? GetXValueAt(int xIndex);

        [Register("getZValueAt", "(I)Ljava/lang/Comparable;", "GetGetZValueAt_IHandler")]
        public abstract global::Java.Lang.Object? GetZValueAt(int zIndex);
    }
}

