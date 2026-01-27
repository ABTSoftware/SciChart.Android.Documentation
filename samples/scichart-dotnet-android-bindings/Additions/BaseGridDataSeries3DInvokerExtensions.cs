using System;
using Android.Runtime;
using Java.Interop;

namespace Com.Scichart.Charting3d.Model.DataSeries.Grid {
    internal partial class BaseGridDataSeries3DInvoker {
        public override unsafe global::Java.Lang.Object? GetXValueAt(int xIndex)
        {
            const string __id = "getXValueAt.(I)Ljava/lang/Comparable;";
            JniArgumentValue* __args = stackalloc JniArgumentValue[1];
            __args[0] = new JniArgumentValue(xIndex);
            var __rm = _members.InstanceMethods.InvokeAbstractObjectMethod(__id, this, __args);
            return global::Java.Lang.Object.GetObject<global::Java.Lang.Object>(__rm.Handle, JniHandleOwnership.TransferLocalRef);
        }

        public override unsafe global::Java.Lang.Object? GetZValueAt(int zIndex)
        {
            const string __id = "getZValueAt.(I)Ljava/lang/Comparable;";
            JniArgumentValue* __args = stackalloc JniArgumentValue[1];
            __args[0] = new JniArgumentValue(zIndex);
            var __rm = _members.InstanceMethods.InvokeAbstractObjectMethod(__id, this, __args);
            return global::Java.Lang.Object.GetObject<global::Java.Lang.Object>(__rm.Handle, JniHandleOwnership.TransferLocalRef);
        }
    }
}
