using Android.Runtime;

namespace Com.Scichart.Charting.Model.Datadistributioncalculator {
    public abstract partial class BaseDataDistributionCalculator {
        [Register("onAppendValue", "(Lcom/scichart/data/model/ISciList;Ljava/lang/Comparable;Z)V", "GetOnAppendValue_Lcom_scichart_data_model_ISciList_Ljava_lang_Comparable_ZHandler")]
        public abstract void OnAppendValue(global::Com.Scichart.Data.Model.ISciList? values, global::Java.Lang.Object? newValue, bool acceptUnsortedData);

        [Register("onAppendValues", "(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V", "GetOnAppendValues_Lcom_scichart_data_model_ISciList_ILcom_scichart_core_model_IValues_ZHandler")]
        public abstract void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData);

        [Register("onAppendValues", "(Lcom/scichart/data/model/ISciList;ILjava/lang/Iterable;Z)V", "GetOnAppendValues_Lcom_scichart_data_model_ISciList_ILjava_lang_Iterable_ZHandler")]
        public abstract void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData);

        [Register("onAppendValues", "(Lcom/scichart/data/model/ISciList;I[Ljava/lang/Comparable;Z)V", "GetOnAppendValues_Lcom_scichart_data_model_ISciList_IarrayLjava_lang_Comparable_ZHandler")]
        public abstract void OnAppendValues(global::Com.Scichart.Data.Model.ISciList? values, int countBeforeAppending, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData);

        [Register("onInsertValue", "(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V", "GetOnInsertValue_Lcom_scichart_data_model_ISciList_ILjava_lang_Comparable_ZHandler")]
        public abstract void OnInsertValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, global::Java.Lang.Object? newValue, bool acceptUnsortedData);

        [Register("onInsertValues", "(Lcom/scichart/data/model/ISciList;IILcom/scichart/core/model/IValues;Z)V", "GetOnInsertValues_Lcom_scichart_data_model_ISciList_IILcom_scichart_core_model_IValues_ZHandler")]
        public abstract void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData);

        [Register("onInsertValues", "(Lcom/scichart/data/model/ISciList;IILjava/lang/Iterable;Z)V", "GetOnInsertValues_Lcom_scichart_data_model_ISciList_IILjava_lang_Iterable_ZHandler")]
        public abstract void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData);

        [Register("onInsertValues", "(Lcom/scichart/data/model/ISciList;II[Ljava/lang/Comparable;Z)V", "GetOnInsertValues_Lcom_scichart_data_model_ISciList_IIarrayLjava_lang_Comparable_ZHandler")]
        public abstract void OnInsertValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereInserted, int insertedCount, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData);

        [Register("onUpdateValue", "(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V", "GetOnUpdateValue_Lcom_scichart_data_model_ISciList_ILjava_lang_Comparable_ZHandler")]
        public abstract void OnUpdateValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData);

        [Register("onUpdateValues", "(Lcom/scichart/data/model/ISciList;IILcom/scichart/core/model/IValues;Z)V", "GetOnUpdateValues_Lcom_scichart_data_model_ISciList_IILcom_scichart_core_model_IValues_ZHandler")]
        public abstract void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData);

        [Register("onUpdateValues", "(Lcom/scichart/data/model/ISciList;IILjava/lang/Iterable;Z)V", "GetOnUpdateValues_Lcom_scichart_data_model_ISciList_IILjava_lang_Iterable_ZHandler")]
        public abstract void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Java.Lang.IIterable? newValues, bool acceptUnsortedData);

        [Register("onUpdateValues", "(Lcom/scichart/data/model/ISciList;II[Ljava/lang/Comparable;Z)V", "GetOnUpdateValues_Lcom_scichart_data_model_ISciList_IIarrayLjava_lang_Comparable_ZHandler")]
        public abstract void OnUpdateValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, int updatedCount, global::Java.Lang.Object[]? newValues, bool acceptUnsortedData);
    }
}

