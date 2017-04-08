package miller.opengl.shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Sphere extends Shape {
  private Color color = new Color(1f, 1f, 1f);
  private float radius = 1f;
  private int slices = 20;
  private int stacks = 20;
  
  public Sphere (float x, float y, float z) {
    super(x, y, z);
  }
  
  @Override
  public void draw(GL2 gl) {
    gl.glLoadIdentity();

    gl.glTranslatef(getTranslateX(), getTranslateY(), getTranslateZ());
    gl.glRotatef(getRotateAngle(), getRotateX(), getRotateY(), getRotateZ());
    gl.glScalef(getScaleX(), getScaleY(), getScaleZ());

    gl.glColor3f(color.getR(), color.getG(), color.getB());
    
    GLUT glut = new GLUT();
    glut.glutSolidSphere(radius, slices, stacks);
    
    gl.glEnd();

    updateTransforms();
    getRenderAction().run(this);
  }
  
  public void setColor (Color color) {
    this.color = color;
  }
}
