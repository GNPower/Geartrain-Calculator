package core.math;

/**
 * 
 * @author Graham Power
 * based of knowledge gathered from the following sources
 * Eric Lengyel. Mathematics for 3D Game Programming and Computer Graphics, Second Edition. Hingham, MA: Charles River Media, 2003. 
 * Jason Gregory. Game Engine Architecture, Second Editino. Boca Raton, FL: Taylor & Francis Group, 2015.
 * https://github.com/fynnfluegge/Lwjgl3-Game-Engine-Programming-Series/tree/starting_code
 **/

public class Vector2f {

	//the x and y coordinates of the 2D vector
	private float x, y;
	
	//creates a zero vector
	public Vector2f() {
		this.x = 0;
		this.y = 0;
	}
	
	//creates a vector with points x and y
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//duplicates a vector from another passed vector
	public Vector2f(Vector2f vec) {
		this.x = vec.getX();
		this.y = vec.getY();
	}
	
	//returns the float length of the vector
	public float length() {
		return (float) Math.sqrt(x*x + y*y);
	}
	
	//returns the float scalar of the dot product between this and vector v
	public float dot(Vector2f r) {
		return (x*r.getX() + y*r.getY());
	}
	
	//normalizes this vector
	public Vector2f normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		
		return this;
	}
	
	//adds two vectors together by components
	public Vector2f add(Vector2f r) {
		return new Vector2f(this.x + r.getX(), this.y + r.getY());
	}
	
	//adds a scalar to all vector components
	public Vector2f add(float r) {
		return new Vector2f(this.x + r, this.y + r);
	}
	
	//subtracts two vectors together by components
	public Vector2f sub(Vector2f r) {
		return new Vector2f(this.x - r.getX(), this.y - r.getY());
	}
	
	//subtracts a scalar from all vector components
	public Vector2f sub(float r) {
		return new Vector2f(this.x - r, this.y - r);
	}
	
	//multiplies two vectors by their components
	public Vector2f mul(Vector2f r) {
		return new Vector2f(this.x * r.getX(), this.y * r.getY());
	}
	
	//multiplies a vectors components by a scalar
	public Vector2f mul(float r) {
		return new Vector2f(this.x * r, this.y * r);
	}
	
	//divides two vectors by their components
	public Vector2f div(Vector2f r)	{
		return new Vector2f(this.x / r.getX(), this.y / r.getY());
	}
	
	//divides a vectors components by a scalar
	public Vector2f div(float r) {
		return new Vector2f(this.x / r, this.y / r);
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
}
