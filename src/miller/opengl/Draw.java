package miller.opengl;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Draw {
  static Shape s;
  public static void main (String[] args) {
    final GLProfile profile = GLProfile.get(GLProfile.GL2);
    GLCapabilities capabilities = new GLCapabilities(profile);
    
    final GLCanvas glcanvas = new GLCanvas(capabilities);
    Drawing drawing = new Drawing();
  
    s = new Square(-4f, 2f, -10f);
    s.setTranslation(0.05f, -0.05f, 0.1f);
    s.setRotation(-1f);
    s.setAction(new TranslationAction () {
      @Override
      public void run() {
        if (s.getTranslateX() < -4 || s.getTranslateX() > 4) {
          s.setTranslateDeltaX(s.getTranslateDeltaX() * -1);;
        }
        if (s.getTranslateY() < -3 || s.getTranslateY() > 3) {
          s.setTranslateDeltaY(s.getTranslateDeltaY() * -1);;
        }
        if (s.getTranslateZ() < -20 || s.getTranslateZ() > -10) {
          s.setTranslateDeltaZ(s.getTranslateDeltaZ() * -1);;
        }
      }
    });
    drawing.shapes.add(s);
    
    glcanvas.addGLEventListener(drawing);  
    glcanvas.setSize(640, 480);
  
    final JFrame frame = new JFrame ("Project 2");
    frame.getContentPane().add(glcanvas);
    frame.setSize(frame.getContentPane().getPreferredSize());
    frame.setVisible(true);
    final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
  
    animator.start();
  }
}
