package miller.opengl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import miller.opengl.shapes.RenderAction;
import miller.opengl.shapes.Shape;
import miller.opengl.shapes.Square;

public class World implements GLEventListener, KeyListener {
  private static final float FOV = 45f;
  
  private GLU glu = new GLU();
  public ArrayList<Shape> shapes = new ArrayList<Shape>();
  
//  private Player player = new Player();
  
  public World () {
    RenderAction ra = new RenderAction() {
      @Override
      public void run(Shape s) {
        if (s.getTranslateX() < -4 || s.getTranslateX() > 4)
          s.setTranslateDeltaX(s.getTranslateDeltaX() * -1);;
        if (s.getTranslateY() < -3 || s.getTranslateY() > 3)
          s.setTranslateDeltaY(s.getTranslateDeltaY() * -1);;
        if (s.getTranslateZ() < -20 || s.getTranslateZ() > -10)
          s.setTranslateDeltaZ(s.getTranslateDeltaZ() * -1);;
        if (s.getScaleX() > 2 || s.getScaleX() < 0.5f)
          s.setScaleDelta(s.getScaleDeltaX() * -1);
      }
    };
    
    Shape shape = new Square(-4f, 2f, -10f);
    shape.setTranslation(0.05f, -0.05f, 0.1f);
    shape.setRotation(-1f);
    shape.setScaleDelta(0.05f);
    shape.setAction(ra);
    shapes.add(shape);
    
    shape = new Square(0f, 2f, -10f);
    shape.setTranslation(0.01f, -0.1f, 0.17f);
    shape.setRotation(-1.5f);
    shape.setScaleDelta(0.01f);
    shape.setAction(ra);
    shapes.add(shape);

    shape = new Square(4f, 2f, -10f);
    shape.setTranslation(0.03f, -0.01f, 0.2f);
    shape.setRotation(-1.2f);
    shape.setScaleDelta(0.03f);
    shape.setAction(ra);
    shapes.add(shape);

    shape = new Square(-4f, -2f, -10f);
    shape.setTranslation(0.01f, -0.02f, 0.3f);
    shape.setRotation(-3f);
    shape.setScaleDelta(0.02f);
    shape.setAction(ra);
    shapes.add(shape);

    shape = new Square(0f, -2f, -10f);
    shape.setTranslation(0.03f, -0.02f, 0.1f);
    shape.setRotation(-2f);
    shape.setScaleDelta(0.02f);
    shape.setAction(ra);
    shapes.add(shape);

    shape = new Square(4f, -2f, -10f);
    shape.setTranslation(0.03f, -0.03f, 0.3f);
    shape.setRotation(-1.8f);
    shape.setScaleDelta(0.01f);
    shape.setAction(ra);
    shapes.add(shape);
  }
  
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

  @Override
  public void keyPressed(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
  }
}
