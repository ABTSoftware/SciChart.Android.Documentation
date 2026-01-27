using System;
using Android.Runtime;
using Java.Interop;

namespace Com.Scichart.Charting.Model.DataSeries {
    internal partial class XDataSeriesInvoker {
        public override unsafe global::Com.Scichart.Data.Model.IRange? GetWindowedYRange(global::Com.Scichart.Charting.Numerics.CoordinateCalculators.ICoordinateCalculator? xCoordCalc, bool getPositiveRange)
        {
            const string __id = "getWindowedYRange.(Lcom/scichart/charting/numerics/coordinateCalculators/ICoordinateCalculator;Z)Lcom/scichart/data/model/IRange;";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[2];
                __args[0] = new JniArgumentValue((xCoordCalc == null) ? IntPtr.Zero : ((global::Java.Lang.Object)xCoordCalc).Handle);
                __args[1] = new JniArgumentValue(getPositiveRange);
                var __rm = _members.InstanceMethods.InvokeAbstractObjectMethod(__id, this, __args);
                return global::Java.Lang.Object.GetObject<global::Com.Scichart.Data.Model.IRange>(__rm.Handle, JniHandleOwnership.TransferLocalRef);
            } finally {
                global::System.GC.KeepAlive(xCoordCalc);
            }
        }

        public override unsafe global::Com.Scichart.Data.Model.IRange? GetWindowedYRange(global::Com.Scichart.Data.Model.IndexRange? xIndexRange, bool getPositiveRange)
        {
            const string __id = "getWindowedYRange.(Lcom/scichart/data/model/IndexRange;Z)Lcom/scichart/data/model/IRange;";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[2];
                __args[0] = new JniArgumentValue((xIndexRange == null) ? IntPtr.Zero : ((global::Java.Lang.Object)xIndexRange).Handle);
                __args[1] = new JniArgumentValue(getPositiveRange);
                var __rm = _members.InstanceMethods.InvokeAbstractObjectMethod(__id, this, __args);
                return global::Java.Lang.Object.GetObject<global::Com.Scichart.Data.Model.IRange>(__rm.Handle, JniHandleOwnership.TransferLocalRef);
            } finally {
                global::System.GC.KeepAlive(xIndexRange);
            }
        }
    }
}
