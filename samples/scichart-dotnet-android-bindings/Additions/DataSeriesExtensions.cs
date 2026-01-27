using Android.Runtime;
using Java.Interop;

namespace Com.Scichart.Charting.Model.DataSeries {
    public abstract partial class DataSeries {
        [Register("getWindowedYRange", "(Lcom/scichart/charting/numerics/coordinateCalculators/ICoordinateCalculator;Z)Lcom/scichart/data/model/IRange;", "GetGetWindowedYRange_Lcom_scichart_charting_numerics_coordinateCalculators_ICoordinateCalculator_ZHandler")]
        public abstract global::Com.Scichart.Data.Model.IRange? GetWindowedYRange(global::Com.Scichart.Charting.Numerics.CoordinateCalculators.ICoordinateCalculator? xCoordCalc, bool getPositiveRange);

        [Register("getWindowedYRange", "(Lcom/scichart/data/model/IndexRange;Z)Lcom/scichart/data/model/IRange;", "GetGetWindowedYRange_Lcom_scichart_data_model_IndexRange_ZHandler")]
        public abstract global::Com.Scichart.Data.Model.IRange? GetWindowedYRange(global::Com.Scichart.Data.Model.IndexRange? xIndexRange, bool getPositiveRange);
    }
}

