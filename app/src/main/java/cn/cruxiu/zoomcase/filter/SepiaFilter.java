package cn.cruxiu.zoomcase.filter;

import android.content.Context;
import android.opengl.GLES20;

import cn.cruxiu.zoomcase.MyGLUtils;
import cn.cruxiu.zoomcase.R;
@startuml
public class SepiaFilter extends zoomcase {
    private int program;

    public SepiaFilter(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.sepia);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId},
                new int[][]{});
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }
}
@enduml