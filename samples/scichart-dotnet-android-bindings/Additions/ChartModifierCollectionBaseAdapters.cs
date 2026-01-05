using Com.Scichart.Core.Observable;

namespace Com.Scichart.Charting.Model {
    public abstract partial class ChartModifierCollectionBase {
        public virtual void OnCollectionChanged(int propertyId, CollectionChangedEventArgs? args)
        {
        }
    }
}
