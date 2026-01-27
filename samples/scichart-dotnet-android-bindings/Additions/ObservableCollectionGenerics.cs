using System.Collections;
using Android.Runtime;

namespace Com.Scichart.Core.Observable {
    [Register (".dummy", DoNotGenerateAcw = true)]
    public class ObservableCollection<T> : ObservableCollection {
        public ObservableCollection() {
        }

        public ObservableCollection(int capacity) : base(capacity) {
        }

        public ObservableCollection(ICollection? collection) : base(collection) {
        }

        protected ObservableCollection(System.IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer) {
        }
    }

    [Register (".dummy", DoNotGenerateAcw = true)]
    public class CollectionChangedEventArgs<T> : CollectionChangedEventArgs {
        public CollectionChangedEventArgs() {
        }

        protected CollectionChangedEventArgs(System.IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer) {
        }
    }
}

