package miller.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Drawing extends JPanel{
  private static final long serialVersionUID = 1L;
  
  private static final int HEIGHT = 25;
  private static final int WIDTH = 25;
  
  private BufferedImage canvas;
  private Shape shape;
  
  private int translateX = 0;
  private int translateY = 0;
  private double scaleX = 1;
  private double scaleY = 1;
  private double rotation = 0;

  public Drawing(Shape shape) {
    super();
    this.canvas = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    this.shape = shape;
  }
  
  public void drawArray() {
    for (int i = 0; i < shape.getArray().length; i++) {
      for (int j = 0; j < shape.getArray()[i].length; j++) {
        if (shape.getArray()[i][j] == 1) {
          canvas.setRGB(i, j, Color.BLACK.getRGB());
        }
      }
    }
    repaint();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    int x = (this.getWidth() - canvas.getWidth(null)) / 2;
    int y = (this.getHeight() - canvas.getHeight(null)) / 2;

    g2.rotate(rotation, x, y);
    g2.scale(scaleX, scaleY);
    g2.translate(translateX, translateY);
    
    g2.drawImage(canvas, x, y, null);
    g2.dispose();
  }
  
  public void rotate(double d) {
    this.rotation += d;
    repaint();
  }
  
  public void scale(double x, double y) {
    this.scaleX = x;
    this.scaleY = y;
    repaint();
  }
  
  public void translate(int x, int y) {
    this.translateX += x;
    this.translateY += y;
    repaint();
  }
}
