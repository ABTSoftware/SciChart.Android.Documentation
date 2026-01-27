using Android.Views;
using Com.Scichart.Core.Framework;

namespace Com.Scichart.Charting.Visuals.Layout {
    public partial class CanvasViewContainer : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class FrameViewContainer : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class LinearViewContainer : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Drawing.Canvas {
    public partial class RenderSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Drawing.Opengl {
    public partial class RenderSurfaceGL : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class GLTextureView : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Charting.Visuals.Annotations {
    public partial class AdornerLayer : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class AnnotationSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Charting.Visuals {
    public abstract partial class SciChartSurfaceBase : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class SciChartSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class SciPieChartSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class RenderableSeriesArea : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }

    public partial class ChartModifierSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Charting.Visuals.Axes {
    public partial class AxisModifierSurface : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Charting.Modifiers.Behaviors {
    public abstract partial class TooltipContainerBase : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

namespace Com.Scichart.Charting3d.Visuals {
    public abstract partial class SciChartSurface3D : IView {
        int IView.Visibility {
            get => (int)Visibility;
            set => Visibility = (ViewStates)value;
        }
    }
}

