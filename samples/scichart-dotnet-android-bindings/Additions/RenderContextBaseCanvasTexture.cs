using System;
using Android.Runtime;
using Java.Interop;

namespace Com.Scichart.Drawing.Common {
    public abstract partial class RenderContextBase {
        [Register("drawCanvasTexture", "(Lcom/scichart/drawing/common/ICanvasTexture2D;Lcom/scichart/core/common/Action1;)V", "GetDrawCanvasTexture_Lcom_scichart_drawing_common_ICanvasTexture2D_Lcom_scichart_core_common_Action1_Handler")]
        public unsafe virtual void DrawCanvasTexture(global::Com.Scichart.Drawing.Common.ICanvasTexture2D? texture, global::Com.Scichart.Core.Common.IAction1? drawCallback)
        {
            const string __id = "drawCanvasTexture.(Lcom/scichart/drawing/common/ICanvasTexture2D;Lcom/scichart/core/common/Action1;)V";
            try {
                JniArgumentValue* __args = stackalloc JniArgumentValue[2];
                __args[0] = new JniArgumentValue((texture == null) ? IntPtr.Zero : ((global::Java.Lang.Object)texture).Handle);
                __args[1] = new JniArgumentValue((drawCallback == null) ? IntPtr.Zero : ((global::Java.Lang.Object)drawCallback).Handle);
                _members.InstanceMethods.InvokeVirtualVoidMethod(__id, this, __args);
            } finally {
                global::System.GC.KeepAlive(texture);
                global::System.GC.KeepAlive(drawCallback);
            }
        }
    }
}
