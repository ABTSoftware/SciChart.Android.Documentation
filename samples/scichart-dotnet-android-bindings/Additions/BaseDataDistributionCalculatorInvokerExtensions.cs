using System;
using Android.Runtime;
using Java.Interop;

namespace Com.Scichart.Charting.Model.Datadistributioncalculator {
    internal partial class BaseDataDistributionCalculatorInvoker {
        public override unsafe void OnAppendValue(global::Com.Scichart.Data.Model.ISciList? values, global::Java.Lang.Object? newValue, bool acceptUnsortedData)
        {
            const string __id = "onAppendValue.(Lcom/scichart/data/model/ISciList;Ljava/lang/Comparable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[3];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue((newValue == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValue).Handle);
                __args[2] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValue);
            }
        }

        public override unsafe void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData)
        {
            const string __id = "onAppendValues.(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(countBeforeAppending);
                __args[2] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData)
        {
            const string __id = "onAppendValues.(Lcom/scichart/data/model/ISciList;ILjava/lang/Iterable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(countBeforeAppending);
                __args[2] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData)
        {
            const string __id = "onAppendValues.(Lcom/scichart/data/model/ISciList;I[Ljava/lang/Comparable;Z)V";
            IntPtr native_newValues = JNIEnv.NewArray(newValues);
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(countBeforeAppending);
                __args[2] = new JniArgumentValue(native_newValues);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                if (newValues != null) {
                    JNIEnv.CopyArray(native_newValues, newValues);
                    JNIEnv.DeleteLocalRef(native_newValues);
                }
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnInsertValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, global::Java.Lang.Object? newValue, bool acceptUnsortedData)
        {
            const string __id = "onInsertValue.(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[4];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereInserted);
                __args[2] = new JniArgumentValue((newValue == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValue).Handle);
                __args[3] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValue);
            }
        }

        public override unsafe void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData)
        {
            const string __id = "onInsertValues.(Lcom/scichart/data/model/ISciList;IILcom/scichart/core/model/IValues;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereInserted);
                __args[2] = new JniArgumentValue(insertedCount);
                __args[3] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData)
        {
            const string __id = "onInsertValues.(Lcom/scichart/data/model/ISciList;IILjava/lang/Iterable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereInserted);
                __args[2] = new JniArgumentValue(insertedCount);
                __args[3] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData)
        {
            const string __id = "onInsertValues.(Lcom/scichart/data/model/ISciList;II[Ljava/lang/Comparable;Z)V";
            IntPtr native_newValues = JNIEnv.NewArray(newValues);
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereInserted);
                __args[2] = new JniArgumentValue(insertedCount);
                __args[3] = new JniArgumentValue(native_newValues);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                if (newValues != null) {
                    JNIEnv.CopyArray(native_newValues, newValues);
                    JNIEnv.DeleteLocalRef(native_newValues);
                }
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnUpdateValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData)
        {
            const string __id = "onUpdateValue.(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V";
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

        public override unsafe void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData)
        {
            const string __id = "onUpdateValues.(Lcom/scichart/data/model/ISciList;IILcom/scichart/core/model/IValues;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue(updatedCount);
                __args[3] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData)
        {
            const string __id = "onUpdateValues.(Lcom/scichart/data/model/ISciList;IILjava/lang/Iterable;Z)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue(updatedCount);
                __args[3] = new JniArgumentValue((newValues == null) ? IntPtr.Zero : ((global::Java.Lang.Object)newValues).Handle);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }

        public override unsafe void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData)
        {
            const string __id = "onUpdateValues.(Lcom/scichart/data/model/ISciList;II[Ljava/lang/Comparable;Z)V";
            IntPtr native_newValues = JNIEnv.NewArray(newValues);
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[5];
                __args[0] = new JniArgumentValue((values == null) ? IntPtr.Zero : ((global::Java.Lang.Object)values).Handle);
                __args[1] = new JniArgumentValue(indexWhereUpdate);
                __args[2] = new JniArgumentValue(updatedCount);
                __args[3] = new JniArgumentValue(native_newValues);
                __args[4] = new JniArgumentValue(acceptUnsortedData);
                _members.InstanceMethods.InvokeAbstractVoidMethod(__id, this, __args);
            } finally {
                if (newValues != null) {
                    JNIEnv.CopyArray(native_newValues, newValues);
                    JNIEnv.DeleteLocalRef(native_newValues);
                }
                global::System.GC.KeepAlive(values);
                global::System.GC.KeepAlive(newValues);
            }
        }
    }
}

