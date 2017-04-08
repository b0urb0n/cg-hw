package miller.opengl.shapes;

public class Color {
  private float r = 1f;
  private float g = 1f;
  private float b = 1f;

  public Color () {}
  
  public Color (float r, float g, float b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public float getR () {
    return r;
  }

  public void setR (float r) {
    this.r = r;
  }

  public float getG () {
    return g;
  }

  public void setG (float g) {
    this.g = g;
  }

  public float getB () {
    return b;
  }

  public void setB (float b) {
    this.b = b;
  }
}
