package miller.opengl.shapes;

public class Face {
  private Point[] points;
  private Color color = new Color(1f, 1f, 1f);
  
  public Face () {}
  
  public Face (Point[] points) {
    this.points = points;
  }

  public Face (Point[] points, Color color) {
    this.points = points;
    this.color = color;
  }
  
  public void setPoints (Point[] points) {
    this.points = points;
  }
  
  public Point[] getPoints () {
    return points;
  }

  public Color getColor () {
    return color;
  }

  public void setColor (Color color) {
    this.color = color;
  }
}
