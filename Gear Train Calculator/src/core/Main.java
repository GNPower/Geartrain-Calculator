package core;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Graham. This is a test.");
		int minTeeth = 12;
		double minModule = 1.0;
		int teamNum = 0;
		double speedFactor;
		if (teamNum < 5)
			speedFactor = 42.33;
		else if (teamNum < 11)
			speedFactor = 10.25;
		else if (teamNum < 35)
			speedFactor = 3.55;
		else if (teamNum < 100)
			speedFactor = 1.33;
		else
			speedFactor = 0.84;
		double inputSpeed = speedFactor*teamNum;


	}

}
