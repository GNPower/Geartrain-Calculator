package core.algorithm;

import java.util.ArrayList;

import core.files.Constants;
import core.files.Reader;
import core.math.Fraction;

public class Calculator2 {

	ArrayList<Design> designs;	
	Reader reader;

	String constraintsFile, designFile;
	int designCount = 0;
	/**
	 * creates a calculator to calculate all the given designs
	 * @param constraintsFile the file with the constraints for the design
	 * @param designFile the file with all the designs to be created
	 */
	public Calculator2(String constraintsFile, String designFile) {
		designs = new ArrayList<Design>();
		reader = new Reader();
		this.constraintsFile = constraintsFile;
		this.designFile = designFile;
	}

	/**
	 * loads all the data from the classes files and sets the designCount, the amount of designs that must be created
	 */
	public void loadData() {
		Reader.readConstraints(constraintsFile);
		Constants.getConstants().printConstants();

		reader.readSpecifications(designFile);
		for(int i = 0; i < reader.getSpecifications().size(); i++) {
			System.out.println(reader.getSpecifications().get(i).toString());
		}
		designCount = reader.getSpecifications().size();
	}

	/**
	 * the method that tells the calculator to start designing
	 * @param designIndex the design to create (from 1 to however many designs were specified in the file), or -1 to design them all
	 */
	public void design(int designIndex) {
		if (designIndex > 0) {
			createDesign(designIndex - 1);
		} else {
			for (int i = 0; i < designCount; i++) {
				createDesign(i);
			}
		}
	}

	/**
	 * creates a single design and stores it in the list of designs
	 * @param index the index in the Readers list of specifications to design from
	 */
	private void createDesign(int index) {
		double gearRatio = getGearRatio(index);
		System.out.println("The Gear Ratio Is: " + gearRatio);
		Fraction fracGR = new Fraction(Util.round(gearRatio, 3));
		System.out.println("Gear Ratio Fractio Is: " + fracGR.toString());
		fracGR.multiply(351);
		System.out.println("Gear Ratio Fractio Is: " + fracGR.toString());
		fracGR.reduce();
		System.out.println("Gear Ratio Fractio Is: " + fracGR.toString());
	}
	
	private double getGearRatio(int index) {
		float input = reader.getSpecifications().get(index).getSpeed1();// * (float) (Math.pow(10, Constants.DECIMAL_ACCURACY));
		float output = reader.getSpecifications().get(index).getSpeed2();// * (float) (Math.pow(10, Constants.DECIMAL_ACCURACY));
		
		System.out.println("Input Speed: " + input + "\nOutput Speed: " + output);
		
		double gearRatio = output/input;
		
		if(gearRatio < 1.0) {
			return 1.0/gearRatio;
		}
		return gearRatio;
	}
	
	private int[] fractionalRatio(double gr, int decAccuracy) {
		int[] data = new int[2];
		
		int multiplier = (int) Math.pow(10, decAccuracy);
		
		data[0] = (int) (gr * multiplier);
		data[1] = multiplier;
		
		return data;
	}
}
