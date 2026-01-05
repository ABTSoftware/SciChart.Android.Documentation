using System;
using Java.Interop;

namespace Com.Scichart.Charting.Model.Datadistributioncalculator {
    internal partial class BaseHeatmapDataDistributionCalculatorInvoker {
        public override unsafe void OnUpdateXValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData)
        {
            const string __id = "onUpdateXValue.(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue((newValue == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValue).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValue);
            }
        }

        public override unsafe void OnUpdateXValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData)
        {
            const string __id = "onUpdateXValues.(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnUpdateYValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData)
        {
            const string __id = "onUpdateYValue.(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue((newValue == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValue).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValue);
            }
        }

        public override unsafe void OnUpdateYValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData)
        {
            const string __id = "onUpdateYValues.(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }
    }
}

