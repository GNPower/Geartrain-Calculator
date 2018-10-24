package core.math;

/**
 * 
 * @author Graham Power
 * based of knowledge gathered from the following sources
 * Eric Lengyel. Mathematics for 3D Game Programming and Computer Graphics, Second Edition. Hingham, MA: Charles River Media, 2003. 
 * Jason Gregory. Game Engine Architecture, Second Editino. Boca Raton, FL: Taylor & Francis Group, 2015.
 * https://github.com/fynnfluegge/Lwjgl3-Game-Engine-Programming-Series/tree/starting_code
 **/

public class Vector3f {

	private float x, y, z;

	//creates a zero vector
	public Vector3f() {
		this.setX(0);
		this.setY(0);
		this.setZ(0);
	}
	
	//creates a vector out of the passed in components
	public Vector3f(float x, float y, float z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	//creates a duplicate vector out of a passed vector
	public Vector3f(Vector3f v) {
		this.x = v.getX();
		this.y = v.getY();
		this.z = v.getZ();
	}
	
	//returns the float length of the vector
	public float length() {
		return (float) Math.sqrt(x*x + y*y + z*z);
	}
	
	//return the dot product between this and a passed in vector
	public float dot(Vector3f r) {
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}
	
	//returns the cross product between this and a passed in vecotr
	public Vector3f cross(Vector3f r) {
		float x = this.y * r.getZ() - this.z * r.getY();
		float y = this.z * r.getX() - this.x * r.getZ();
		float z = this.x * r.getY() - this.y * r.getX();
		
		return new Vector3f(x,y,z);
	}
	
	//normalizs this vector and returns it
	public Vector3f normalize() {
		float length = this.length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	
	//rotates this vector a specific angle around a vector axis
	public Vector3f rotate(float angle, Vector3f axis) {
		float sinHalfAngle = (float)Math.sin(Math.toRadians(angle / 2));
		float cosHalfAngle = (float)Math.cos(Math.toRadians(angle / 2));
		
		float rX = axis.getX() * sinHalfAngle;
		float rY = axis.getY() * sinHalfAngle;
		float rZ = axis.getZ() * sinHalfAngle;
		float rW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(rX, rY, rZ, rW);
		Quaternion conjugate = rotation.conjugate();
		
		Quaternion w = rotation.mul(this).mul(conjugate);
		
		x = w.getX();
		y = w.getY();
		z = w.getZ();
		
		return this;
	}
	
	//adds two vectors by components
	public Vector3f add(Vector3f r) {
		return new Vector3f(this.x + r.getX(), this.y + r.getY(), this.z + r.getZ());
	}
	
	//adds a float to each vector component
	public Vector3f add(float r) {
		return new Vector3f(this.x + r, this.y + r, this.z + r);
	}
	
	//subtracts two vectors by components
	public Vector3f sub(Vector3f r) {
		return new Vector3f(this.x - r.getX(), this.y - r.getY(), this.z - r.getZ());
	}
	
	//subtracts a float from each vector component
	public Vector3f sub(float r) {
		return new Vector3f(this.x - r, this.y - r, this.z - r);
	}
	
	//multiplies two vectors by components
	public Vector3f mul(Vector3f r) {
		return new Vector3f(this.x * r.getX(), this.y * r.getY(), this.z * r.getZ());
	}
	
	//multiplies a vectors components by three components scalars
	public Vector3f mul(float x, float y, float z) {
		return new Vector3f(this.x * x, this.y * y, this.z * z);
	}
	
	//multiplies a vectors components by a scalar
	public Vector3f mul(float r) {
		return new Vector3f(this.x * r, this.y * r, this.z * r);
	}
	
	//divides two vectors by components
	public Vector3f div(Vector3f r) {
		return new Vector3f(this.x / r.getX(), this.y / r.getY(), this.getZ() / r.getZ());
	}
	
	//divides a vectors components by three component scalars
	public Vector3f div(float x, float y, float z) {
		return new Vector3f(this.x / x, this.y / y, this.z / z);
	}
	
	//divides a vectors components by a scalar
	public Vector3f div(float r) {
		return new Vector3f(this.x / r, this.y / r, this.z / r);
	}
	
	//returns the absolute value of the vecotr, ie all components positive
	public Vector3f abs() {
		return new Vector3f(Math.abs(x), Math.abs(y), Math.abs(z));
	}
	
	//checks if a vector is identical to a passed in vector
	public boolean equals(Vector3f v) {
		if (x == v.getX() && y == v.getY() && z == v.getZ())
			return true;
		else return false;
	}
	
	//returns the vector as a formatted string
	public String toString() {
		return "[" + this.x + "," + this.y + "," + this.z + "]";
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
}