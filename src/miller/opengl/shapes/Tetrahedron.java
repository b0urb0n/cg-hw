package miller.opengl.shapes;

import com.jogamp.opengl.GL2;

public class Tetrahedron extends Shape {
  private static final int FACE_TYPE = GL2.GL_TRIANGLES;
  
  public Tetrahedron () {
    super(FACE_TYPE);
    initFaces();
  }
  
  public Tetrahedron (float x, float y, float z) {
    super(FACE_TYPE, x, y, z);
    initFaces();
  }
  
  public Tetrahedron (float x, float y, float z, Face[] faces) {
    super(FACE_TYPE, x, y, z);
    setFaces(faces);
  }
  
  public void initFaces () {
    Face[] faces = new Face[4];
    
    Color c = new Color(1f, 0f, 0f); // red
    Point[] ps = new Point[3]; // 4 points to a quad
    ps[0] = new Point(0f, 0f, 1f);
    ps[1] = new Point(0f, 1f, -1f);
    ps[2] = new Point(1f, -1f, -1f);
    faces[0] = new Face(ps, c);
    
    c = new Color(0f, 1f, 0f); // green
    ps = new Point[3];
    ps[0] = new Point(0f, 0f, 1f);
    ps[1] = new Point(1f, -1f, -1f);
    ps[2] = new Point(-1f, -1f, -1f);
    faces[1] = new Face(ps, c);

    c = new Color(0f, 0f, 1f); // blue
    ps = new Point[3];
    ps[0] = new Point(0f, 0f, 1f);
    ps[1] = new Point(-1f, -1f, -1f);
    ps[2] = new Point(0f, 1f, -1f);
    faces[2] = new Face(ps, c);

    c = new Color(1f, 1f, 0f); // yellow
    ps = new Point[3];
    ps[0] = new Point(0f, 1f, -1f);
    ps[1] = new Point(1f, -1f, -1f);
    ps[2] = new Point(-1f, -1f, -1f);
    faces[3] = new Face(ps, c);

    setFaces(faces);
  }
}
