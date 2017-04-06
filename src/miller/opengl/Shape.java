package miller.opengl;

import com.jogamp.opengl.GL2;

public class Shape {
  private TranslationAction action;
  
  protected float scaleX = 1.0f;
  protected float scaleY = 1.0f;
  protected float scaleZ = 1.0f;
  private float scaleDeltaX = 0.0f;
  private float scaleDeltaY = 0.0f;
  private float scaleDeltaZ = 0.0f;

  protected float rotateAngle = 0.0f;
  private float rotateAngleDelta = 0.0f;
  protected float rotateX = 1.0f;
  protected float rotateY = 1.0f;
  protected float rotateZ = 1.0f;
  
  protected float translateX = 0.0f;
  protected float translateY = 0.0f;
  protected float translateZ = 0.0f;
  private float translateDeltaX = 0.0f;
  private float translateDeltaY = 0.0f;
  private float translateDeltaZ = 0.0f;
  
  public Shape (float x, float y, float z) {
    translateX = x;
    translateY = y;
    translateZ = z;
  }
  
  protected void updateTransforms () {
    rotateAngle += rotateAngleDelta;

    translateX += translateDeltaX;
    translateY += translateDeltaY;
    translateZ += translateDeltaZ;
        
    scaleX += scaleDeltaX;
    scaleY += scaleDeltaY;
    scaleZ += scaleDeltaZ;
  }
  
  public void draw (GL2 gl) {}
  
  public void setRotation (float a) {
    rotateAngleDelta = a;
  }
  
  public void setScale (float x, float y, float z) {
    scaleDeltaX = x;
    scaleDeltaY = y;
    scaleDeltaZ = z;
  }
  
  public void setTranslation (float x, float y, float z) {
    translateDeltaX = x;
    translateDeltaY = y;
    translateDeltaZ = z;
  }

  public TranslationAction getAction() {
    return action;
  }

  public void setAction(TranslationAction action) {
    this.action = action;
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
}
