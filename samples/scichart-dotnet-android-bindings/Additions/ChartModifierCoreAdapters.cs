namespace Com.Scichart.Charting.Modifiers {
    public partial class ChartModifierCore : IChartModifierCore, Com.Scichart.Core.Utility.Touch.IReceiveMotionEvents {
        bool IChartModifierCore.IsEnabled {
            get => IsEnabled;
            set => SetIsEnabledInternal(value);
        }

        bool Com.Scichart.Core.Utility.Touch.IReceiveMotionEvents.IsEnabled => IsEnabled;

        bool Com.Scichart.Core.Utility.Touch.IReceiveMotionEvents.ReceiveHandledEvents => ReceiveHandledEvents;
    }
}
