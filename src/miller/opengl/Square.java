package miller.opengl;

import com.jogamp.opengl.GL2;

public class Square extends Shape {
  int faceType = GL2.GL_QUADS;
  
  public Square(float x, float y, float z) {
    super(x, y, z);
  }
  
  @Override
  public void draw(GL2 gl) {
    gl.glLoadIdentity();
    
    gl.glTranslatef(translateX, translateY, translateZ);
    gl.glRotatef(rotateAngle, rotateX, rotateY, rotateZ);
    gl.glScalef(scaleX, scaleY, scaleZ);
    
    gl.glBegin(GL2.GL_QUADS);
    gl.glColor3f(1f, 0f, 0f); // red
    gl.glVertex3f(1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(1.0f, 1.0f, 1.0f);

    gl.glColor3f(0f, 1f, 0f); // green
    gl.glVertex3f(1.0f, -1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(1.0f, -1.0f, -1.0f);

    gl.glColor3f(0f, 0f, 1f); // blue
    gl.glVertex3f(1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, 1.0f);

    gl.glColor3f(1f, 1f, 0f); // yellow
    gl.glVertex3f(1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(1.0f, 1.0f, -1.0f);

    gl.glColor3f(1f, 0f, 1f); // purple
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);

    gl.glColor3f(1f, 1f, 1f); // white
    gl.glVertex3f(1.0f, 1.0f, -1.0f);
    gl.glVertex3f(1.0f, 1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, -1.0f);
    gl.glEnd();

    updateTransforms();
    getAction().run();
  }
}
