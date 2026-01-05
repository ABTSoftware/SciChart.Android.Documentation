using Android.Runtime;

namespace Com.Scichart.Charting.Model.Datadistributioncalculator {
    public abstract partial class BaseHeatmapDataDistributionCalculator {
        [Register("onUpdateXValue", "(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V", "GetOnUpdateXValue_Lcom_scichart_data_model_ISciList_ILjava_lang_Comparable_ZHandler")]
        public abstract void OnUpdateXValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData);

        [Register("onUpdateXValues", "(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V", "GetOnUpdateXValues_Lcom_scichart_data_model_ISciList_ILcom_scichart_core_model_IValues_ZHandler")]
        public abstract void OnUpdateXValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData);

        [Register("onUpdateYValue", "(Lcom/scichart/data/model/ISciList;ILjava/lang/Comparable;Z)V", "GetOnUpdateYValue_Lcom_scichart_data_model_ISciList_ILjava_lang_Comparable_ZHandler")]
        public abstract void OnUpdateYValue(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Java.Lang.Object? newValue, bool acceptUnsortedData);

        [Register("onUpdateYValues", "(Lcom/scichart/data/model/ISciList;ILcom/scichart/core/model/IValues;Z)V", "GetOnUpdateYValues_Lcom_scichart_data_model_ISciList_ILcom_scichart_core_model_IValues_ZHandler")]
        public abstract void OnUpdateYValues(global::Com.Scichart.Data.Model.ISciList? values, int indexWhereUpdate, global::Com.Scichart.Core.Model.IValues? newValues, bool acceptUnsortedData);
    }
}

