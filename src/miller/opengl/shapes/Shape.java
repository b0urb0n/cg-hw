package miller.opengl.shapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.jogamp.opengl.GL2;

public class Shape {
  private RenderAction renderAction = new RenderAction();
  private int faceType;
  private Face[] faces;

  private boolean scale = false;
  private float scaleX = 1.0f;
  private float scaleY = 1.0f;
  private float scaleZ = 1.0f;
  private float scaleDeltaX = 0.0f;
  private float scaleDeltaY = 0.0f;
  private float scaleDeltaZ = 0.0f;

  private boolean rotate = false;
  private float rotateAngle = 0.0f;
  private float rotateAngleDelta = 0.0f;
  private float rotateX = 1.0f;
  private float rotateY = 1.0f;
  private float rotateZ = 1.0f;

  private boolean translate = false;
  private float translateX = 0.0f;
  private float translateY = 0.0f;
  private float translateZ = 0.0f;
  private float translateDeltaX = 0.0f;
  private float translateDeltaY = 0.0f;
  private float translateDeltaZ = 0.0f;

  public JButton scaleButton = new JButton(String.format("%s scale", this.getClass().getSimpleName()));
  public JButton rotationButton = new JButton(String.format("%s rotation", this.getClass().getSimpleName()));
  public JButton translationButton = new JButton(String.format("%s translation", this.getClass().getSimpleName()));

  public Shape() {
    scaleButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        scale = !scale;
      }
    });

    rotationButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        rotate = !rotate;
      }
    });

    translationButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        translate = !translate;
      }
    });
  }

  public Shape(int faceType) {
    this();
    this.faceType = faceType;
  }

  public Shape(float x, float y, float z) {
    this();
    translateX = x;
    translateY = y;
    translateZ = z;
  }

  public Shape(int faceType, float x, float y, float z) {
    this();
    this.faceType = faceType;
    translateX = x;
    translateY = y;
    translateZ = z;
  }

  protected void updateTransforms () {
    if (rotate) {
      rotateAngle += rotateAngleDelta;
    }

    if (translate) {
      translateX += translateDeltaX;
      translateY += translateDeltaY;
      translateZ += translateDeltaZ;
    }
    
    if (scale) {
      scaleX += scaleDeltaX;
      scaleY += scaleDeltaY;
      scaleZ += scaleDeltaZ;
    }
  }

  // this method must be overwritten for things like spheres
  public void draw(GL2 gl) {
    Color c;

    gl.glLoadIdentity();

    gl.glTranslatef(translateX, translateY, translateZ);
    gl.glRotatef(rotateAngle, rotateX, rotateY, rotateZ);
    gl.glScalef(scaleX, scaleY, scaleZ);

    gl.glBegin(faceType);

    for (Face face : faces) {
      c = face.getColor();
      gl.glColor3f(c.getR(), c.getG(), c.getB());

      for (Point point : face.getPoints()) {
        gl.glVertex3f(point.getX(), point.getY(), point.getZ());
      }
    }

    gl.glEnd();

    updateTransforms();
    renderAction.run(this);
  }

  public void setFaces(Face[] faces) {
    this.faces = faces;
  }

  public void setRotation(float a) {
    rotateAngleDelta = a;
  }

  public void setScale(float x, float y, float z) {
    scaleDeltaX = x;
    scaleDeltaY = y;
    scaleDeltaZ = z;
  }

  public void setTranslation(float x, float y, float z) {
    translateDeltaX = x;
    translateDeltaY = y;
    translateDeltaZ = z;
  }

  public RenderAction getAction() {
    return renderAction;
  }

  public void setAction(RenderAction action) {
    this.renderAction = action;
  }

  public void setScaleDelta(float scaleDelta) {
    this.scaleDeltaX = scaleDelta;
    this.scaleDeltaY = scaleDelta;
    this.scaleDeltaZ = scaleDelta;
  }

  public float getScaleDeltaX() {
    return scaleDeltaX;
  }

  public void setScaleDeltaX(float scaleDeltaX) {
    this.scaleDeltaX = scaleDeltaX;
  }

  public float getScaleDeltaY() {
    return scaleDeltaY;
  }

  public void setScaleDeltaY(float scaleDeltaY) {
    this.scaleDeltaY = scaleDeltaY;
  }

  public float getScaleDeltaZ() {
    return scaleDeltaZ;
  }

  public void setScaleDeltaZ(float scaleDeltaZ) {
    this.scaleDeltaZ = scaleDeltaZ;
  }

  public float getRotateAngleDelta() {
    return rotateAngleDelta;
  }

  public void setRotateAngleDelta(float rotateAngleDelta) {
    this.rotateAngleDelta = rotateAngleDelta;
  }

  public float getTranslateDeltaX() {
    return translateDeltaX;
  }

  public void setTranslateDeltaX(float translateDeltaX) {
    this.translateDeltaX = translateDeltaX;
  }

  public float getTranslateDeltaY() {
    return translateDeltaY;
  }

  public void setTranslateDeltaY(float translateDeltaY) {
    this.translateDeltaY = translateDeltaY;
  }

  public float getTranslateDeltaZ() {
    return translateDeltaZ;
  }

  public void setTranslateDeltaZ(float translateDeltaZ) {
    this.translateDeltaZ = translateDeltaZ;
  }

  public float getScaleX() {
    return scaleX;
  }

  public void setScaleX(float scaleX) {
    this.scaleX = scaleX;
  }

  public float getScaleY() {
    return scaleY;
  }

  public void setScaleY(float scaleY) {
    this.scaleY = scaleY;
  }

  public float getScaleZ() {
    return scaleZ;
  }

  public void setScaleZ(float scaleZ) {
    this.scaleZ = scaleZ;
  }

  public float getRotateAngle() {
    return rotateAngle;
  }

  public void setRotateAngle(float rotateAngle) {
    this.rotateAngle = rotateAngle;
  }

  public float getRotateX() {
    return rotateX;
  }

  public void setRotateX(float rotateX) {
    this.rotateX = rotateX;
  }

  public float getRotateY() {
    return rotateY;
  }

  public void setRotateY(float rotateY) {
    this.rotateY = rotateY;
  }

  public float getRotateZ() {
    return rotateZ;
  }

  public void setRotateZ(float rotateZ) {
    this.rotateZ = rotateZ;
  }

  public float getTranslateX() {
    return translateX;
  }

  public void setTranslateX(float translateX) {
    this.translateX = translateX;
  }

  public float getTranslateY() {
    return translateY;
  }

  public void setTranslateY(float translateY) {
    this.translateY = translateY;
  }

  public float getTranslateZ() {
    return translateZ;
  }

  public void setTranslateZ(float translateZ) {
    this.translateZ = translateZ;
  }

  public int getFaceType() {
    return faceType;
  }

  public void setFaceType(int faceType) {
    this.faceType = faceType;
  }
}
