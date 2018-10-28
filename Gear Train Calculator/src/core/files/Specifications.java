package core.files;

import core.math.Vector2f;
import core.math.Vector3f;

public class Specifications {

	private String name;
	private Vector2f chassis_size;
	private Vector3f landmark1, landmark2, landmark3;
	private Constants.Direction dir1, dir2, dir3;
	private float speed1, speed2, speed3;
	private float workspace_diameter, lm2_offset, lm3_offset;
	
	public Specifications(String name) {
		this.setName(name);
	}

	public Vector2f getChassis_size() {
		return chassis_size;
	}

	public void setChassis_size(Vector2f chassis_size) {
		this.chassis_size = chassis_size;
	}

	public Vector3f getLandmark1() {
		return landmark1;
	}

	public void setLandmark1(Vector3f landmark1) {
		this.landmark1 = landmark1;
	}

	public Vector3f getLandmark2() {
		return landmark2;
	}

	public void setLandmark2(Vector3f landmark2) {
		this.landmark2 = landmark2;
	}

	public Vector3f getLandmark3() {
		return landmark3;
	}

	public void setLandmark3(Vector3f landmark3) {
		this.landmark3 = landmark3;
	}

	public Constants.Direction getDir1() {
		return dir1;
	}

	public void setDir1(Constants.Direction dir1) {
		this.dir1 = dir1;
	}

	public Constants.Direction getDir2() {
		return dir2;
	}

	public void setDir2(Constants.Direction dir2) {
		this.dir2 = dir2;
	}

	public Constants.Direction getDir3() {
		return dir3;
	}

	public void setDir3(Constants.Direction dir3) {
		this.dir3 = dir3;
	}

	public float getSpeed1() {
		return speed1;
	}

	public void setSpeed1(float speed1) {
		this.speed1 = speed1;
	}

	public float getSpeed2() {
		return speed2;
	}

	public void setSpeed2(float speed2) {
		this.speed2 = speed2;
	}

	public float getSpeed3() {
		return speed3;
	}

	public void setSpeed3(float speed3) {
		this.speed3 = speed3;
	}

	public float getWorkspace_diameter() {
		return workspace_diameter;
	}

	public void setWorkspace_diameter(float workspace_diameter) {
		this.workspace_diameter = workspace_diameter;
	}

	public float getLm1_offset() {
		return lm2_offset;
	}

	public void setLm1_offset(float lm1_offset) {
		this.lm2_offset = lm1_offset;
	}

	public float getLm2_offset() {
		return lm3_offset;
	}

	public void setLm2_offset(float lm2_offset) {
		this.lm3_offset = lm2_offset;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String d1, d2, d3;
		if(dir1 == Constants.Direction.CW)
			d1 = "CW";
		else
			d1 = "CCW";
		if(dir2 == Constants.Direction.CW)
			d2 = "CW";
		else
			d2 = "CCW";
		if(dir3 == Constants.Direction.CW)
			d3 = "CW";
		else
			d3 = "CCW";
		
		return "\n\n" + name + " Specifications:\n\tChassis Size: " + chassis_size.toString() + 
				"\n\n\tWorkspace:\n\t\tDiameter: " + workspace_diameter + 
				"\n\t\tLandmark Two Offset: " + lm2_offset + "\n\t\tLandmark Three Offset: " +
				lm3_offset + "\n\n\tLandmark One:\n\t\tLocation: " + landmark1.toString() + 
				"\n\t\tRotation: " + d1 + "\n\t\tSpeed: " + speed1 + 
				" rps\n\n\tLandmark Two:\n\t\tLocation: " + landmark2.toString() +
				"\n\t\tRotation: " + d2 + "\n\t\tSpeed: " + speed2 +
				" rps\n\n\tLandmark Three:\n\t\tLocation: " + landmark3.toString() +
				"\n\t\tRotation: " + d3 + "\n\t\tSpeed: " + speed3 + "\n\n--- End Of Specifications ---";
	}
}
