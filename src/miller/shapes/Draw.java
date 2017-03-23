package miller.shapes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw {
  private static ArrayList<Drawing> shapes = new ArrayList<Drawing>();
  
  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Shapes");
    JPanel mainPanel = new JPanel();
    JPanel panel = new JPanel();

    Drawing circle = new Drawing(new ShapeCircle());
    Drawing line = new Drawing(new ShapeLine());
    Drawing plus = new Drawing(new ShapePlus());
    
    shapes.add(circle);
    shapes.add(line);
    shapes.add(plus);
        
    panel.setLayout(new GridLayout(0, 1));
    
    for (Drawing d: shapes) {
      d.drawArray();
      panel.add(d, Container.CENTER_ALIGNMENT);
    }
    
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(panel, Container.CENTER_ALIGNMENT);
    
    frame.setMinimumSize(new Dimension(100, 300));
    frame.add(mainPanel);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    for (Drawing d: shapes) {
      d.translate(-5, 7);
      Thread.sleep(1000);
      d.rotate(-45);
      Thread.sleep(1000);
      d.rotate(90);
      Thread.sleep(1000);
      d.scale(2, 0.5);
      Thread.sleep(1000);
    }
  }
}
