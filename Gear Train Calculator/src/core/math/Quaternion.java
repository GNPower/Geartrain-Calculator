package core.math;

/**
 * 
 * @author Graham Power
 * based of knowledge gathered from the following sources
 * Eric Lengyel. Mathematics for 3D Game Programming and Computer Graphics, Second Edition. Hingham, MA: Charles River Media, 2003. 
 * Jason Gregory. Game Engine Architecture, Second Editino. Boca Raton, FL: Taylor & Francis Group, 2015.
 * https://github.com/fynnfluegge/Lwjgl3-Game-Engine-Programming-Series/tree/starting_code
 **/

public class Quaternion {

	private float x, y, z, w;
	
	//creates a quaternion from passed in component values
	public Quaternion(float x, float y, float z, float w){
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setW(w);
	}
	
	//creates a quaternion from a Vector3f and a imaginary component
	public Quaternion(Vector3f v, float w){
		this.setX(v.getX());
		this.setY(v.getY());
		this.setZ(v.getZ());
		this.setW(w);
	}
	
	//returns the length of the quaternion
	public float length() {
		return (float) Math.sqrt(x*x + y*y + z*z + w*w);
	}
	
	//normalizes this quaternion then returns it
	public Quaternion normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	
	//returns the conjugate as a new quaternion
	public Quaternion conjugate() {
		return new Quaternion (-x, -y, -z, w);
	}
	
	//multiplies this quaternion by another
	public Quaternion mul(Quaternion r) {
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
		float y_ = y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
		float z_ = z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();

		return new Quaternion(x_, y_, z_, w_);
	}

	//multiplies this quaternion by a Vector3f
	public Quaternion mul(Vector3f r) {
		float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ =  w * r.getX() + y * r.getZ() - z * r.getY();
		float y_ =  w * r.getY() + z * r.getX() - x * r.getZ();
		float z_ =  w * r.getZ() + x * r.getY() - y * r.getX();

		return new Quaternion(x_, y_, z_, w_);
	}
	
	//divides this quaternion by a float
	public Quaternion div(float r) {
		float w_ = w/r;
		float x_ = x/r;
		float y_ = y/r;
		float z_ = z/r;
		return new Quaternion(x_, y_, z_, w_);
	}
	
	//multiplies this quaternion by a float
	public Quaternion mul(float r) {
		float w_ = w*r;
		float x_ = x*r;
		float y_ = y*r;
		float z_ = z*r;
		return new Quaternion(x_, y_, z_, w_);
	}
	
	//subtracts a passed in quaternions components from this one and returns the result as a new quaternion
	public Quaternion sub(Quaternion r) {
		float w_ = w - r.getW();
		float x_ = x - r.getX();
		float y_ = y - r.getY();
		float z_ = z - r.getZ();
		return new Quaternion(x_, y_, z_, w_);
	}
	
	//adds two quaternions together and returns the result
	public Quaternion add(Quaternion r) {
		float w_ = w + r.getW();
		float x_ = x + r.getX();
		float y_ = y + r.getY();
		float z_ = z + r.getZ();
		return new Quaternion(x_, y_, z_, w_);
	}
	
	//returns the vector components of the quaternion
	public Vector3f xyz() {
		return new Vector3f(x,y,z);
	}
	
	//returns this quaternion as a formatted string
	public String toString() {
		return "[" + this.x + "," + this.y + "," + this.z + "," + this.w + "]";
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}
}
