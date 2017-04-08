package miller.opengl;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import miller.opengl.shapes.Shape;

public class Main {
  static World world = new World();

  public static void main (String[] args) {
    final JFrame frame = new JFrame ("Project 2");
    Container contentPane = frame.getContentPane();
    JPanel menu = getMenu();

    final GLProfile profile = GLProfile.get(GLProfile.GL2);
    final GLCapabilities capabilities = new GLCapabilities(profile);
    final GLCanvas glcanvas = new GLCanvas(capabilities);
  
    glcanvas.addGLEventListener(world);  
    glcanvas.setSize(640, 480);
    
    SpringLayout layout = new SpringLayout();
    layout.putConstraint(SpringLayout.WEST, glcanvas, 5, SpringLayout.WEST, contentPane);
    layout.putConstraint(SpringLayout.NORTH, glcanvas, 5, SpringLayout.NORTH, contentPane);
    
    layout.putConstraint(SpringLayout.WEST, menu, 5, SpringLayout.EAST, glcanvas);
    layout.putConstraint(SpringLayout.NORTH, menu, 5, SpringLayout.NORTH, contentPane);
    
    layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, menu);
    layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, glcanvas);
    
    contentPane.setLayout(layout);
    contentPane.add(glcanvas);
    contentPane.add(menu);
    
    frame.pack();
    frame.setVisible(true);
    final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
  
    animator.start();
  }
  
  private static JPanel getMenu() {
    JPanel panel = new JPanel();
    BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(layout);
    
    for (Shape s : world.shapes) {
      panel.add(s.scaleButton);
      panel.add(s.rotationButton);
      panel.add(s.translationButton);
    }
    
    return panel;
  }
}
