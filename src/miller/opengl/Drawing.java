package miller.opengl;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Drawing implements GLEventListener {
  private static final float FOV = 45f;
  
  private GLU glu = new GLU();
  public ArrayList<Shape> shapes = new ArrayList<Shape>();
  
  @Override
  public void display (GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();
    
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    
    for (Shape shape : shapes) {
      shape.draw(gl);
    }
    
    gl.glFlush();
  }

  @Override
  public void dispose (GLAutoDrawable drawable) {}

  @Override
  public void init (GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();
    
    gl.glShadeModel(GL2.GL_SMOOTH);
    gl.glClearColor(0f, 0f, 0f, 0f);
    gl.glClearDepth(1.0f);
    gl.glEnable(GL2.GL_DEPTH_TEST);
    gl.glDepthFunc(GL2.GL_LEQUAL);
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
  }

  @Override
  public void reshape (GLAutoDrawable drawable, int x, int y, int width, int height) {
    final GL2 gl = drawable.getGL().getGL2();
    
    if (height <= 0) {
      height = 1;
    }

    final float ar = (float) width / (float) height;

    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();

    glu.gluPerspective(FOV, ar, 1.0, 30.0);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
  }
}
