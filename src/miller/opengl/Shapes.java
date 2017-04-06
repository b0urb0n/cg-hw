package miller.opengl;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class Shapes implements GLEventListener {
  private GLU glu = new GLU();
  private float rotation = 0f;
  
  @Override
  public void display(GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();
    
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    gl.glTranslatef(0f, 0f, -10f);
    gl.glRotatef(rotation, 1f, 1f, 1f);
    
    square(gl, -4f, 2f, 0f);
    square(gl, 0f, 2f, 0f);
    square(gl, 4f, 2f, 0f);
    square(gl, -4f, -2f, 0f);
    square(gl, 0f, -2f, 0f);
    square(gl, 4f, -2f, 0f);
    
    gl.glFlush();
    
    rotation -= 0.15f;
  }

  @Override
  public void dispose(GLAutoDrawable drawable) {}

  @Override
  public void init(GLAutoDrawable drawable) {
    final GL2 gl = drawable.getGL().getGL2();
    
    gl.glShadeModel(GL2.GL_SMOOTH);
    gl.glClearColor(0f, 0f, 0f, 0f);
    gl.glClearDepth(1.0f);
    gl.glEnable(GL2.GL_DEPTH_TEST);
    gl.glDepthFunc(GL2.GL_LEQUAL);
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    final GL2 gl = drawable.getGL().getGL2();
    
    if (height <= 0) {
      height = 1;
    }

    final float h = (float) width / (float) height;

    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();

    glu.gluPerspective(45.0f, h, 1.0, 20.0);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
  }
  
  private void square (GL2 gl, float x, float y, float z) {
    gl.glBegin(GL2.GL_QUADS); // Start Drawing
    gl.glColor3f(1f, 0f, 0f); // red
    gl.glVertex3f(1.0f + x, 1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, 1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, 1.0f + y, 1.0f + z);
    gl.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);

    gl.glColor3f(0f, 1f, 0f); // green
    gl.glVertex3f(1.0f + x, -1.0f + y, 1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, 1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, -1.0f + z);
    gl.glVertex3f(1.0f + x, -1.0f + y, -1.0f + z);

    gl.glColor3f(0f, 0f, 1f); // blue
    gl.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);
    gl.glVertex3f(-1.0f + x, 1.0f + y, 1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, 1.0f + z);
    gl.glVertex3f(1.0f + x, -1.0f + y, 1.0f + z);

    gl.glColor3f(1f, 1f, 0f); // yellow
    gl.glVertex3f(1.0f + x, -1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, 1.0f + y, -1.0f + z);
    gl.glVertex3f(1.0f + x, 1.0f + y, -1.0f + z);

    gl.glColor3f(1f, 0f, 1f); // purple
    gl.glVertex3f(-1.0f + x, 1.0f + y, 1.0f + z);
    gl.glVertex3f(-1.0f + x, 1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, -1.0f + z);
    gl.glVertex3f(-1.0f + x, -1.0f + y, 1.0f + z);

    gl.glColor3f(1f, 1f, 1f); // white
    gl.glVertex3f(1.0f + x, 1.0f + y, -1.0f + z);
    gl.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);
    gl.glVertex3f(1.0f + x, -1.0f + y, 1.0f + z);
    gl.glVertex3f(1.0f + x, -1.0f + y, -1.0f + z);
    gl.glEnd(); // Done Drawing
  }
}
