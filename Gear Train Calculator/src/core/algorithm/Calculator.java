package core.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;

import core.files.Constants;
import core.files.Reader;

public class Calculator {

	ArrayList<Design> designs;
	private static final double[] ONE_HUNDRED_FACTORS = new double[] {2.0,4.0,5.0,10.0,20.0,25.0,50.0,100.0};
	private static ArrayList<double[]> combos = new ArrayList<double[]>();
	
	Reader reader;

	String constraintsFile, designFile;
	int designCount = 0;
	private boolean flippedRatio = false;

	/**
	 * creates a calculator to calculate all the given designs
	 * @param constraintsFile the file with the constraints for the design
	 * @param designFile the file with all the designs to be created
	 */
	public Calculator(String constraintsFile, String designFile) {
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
		double[] factors = getFactors((int)(gearRatio * Math.pow(10, 2)));
		System.out.println(Util.toString(factors));
		double[] extendedFactors = extendFactors(factors);
		System.out.println(Util.toString(extendedFactors));
		System.out.println(extendedFactors.length);
		
		findAllCombinations(factors, gearRatio);
		System.out.println(combos.size());
	}
	
	private double getGearRatio(int index) {
		float input = reader.getSpecifications().get(index).getSpeed1();// * (float) (Math.pow(10, Constants.DECIMAL_ACCURACY));
		float output = reader.getSpecifications().get(index).getSpeed2();// * (float) (Math.pow(10, Constants.DECIMAL_ACCURACY));
		
		System.out.println("Input Speed: " + input + "\nOutput Speed: " + output);
		
		double gearRatio = output/input;
		
		if(gearRatio < 1.0) {
			flippedRatio = true;
			return 1.0/gearRatio;
		}
		return gearRatio;
	}

	/**
	 * gets all the factors of a given number
	 * @param n the number to find factors if
	 * @return the integer array of whole factors of the passed in number
	 */
	private double[] getFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				factors.add(i);
		}
		factors.add(n);
		
		return convertFactors(Util.toIntArray(factors));
	}
	
	private double[] convertFactors(int[] data) {
		double[] result = new double[data.length * ONE_HUNDRED_FACTORS.length];
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < ONE_HUNDRED_FACTORS.length; j++) {
				result[(i*ONE_HUNDRED_FACTORS.length) + j] = data[i] / ONE_HUNDRED_FACTORS[j];
			}
		}
		
		return result;
	}

	
	/**
	 * extends the array so the same number will repeat n times where n is the maximum amount of gear trains allowed in the design
	 * @param factors the original list of factors
	 * @return the extended list of factors
	 */
	private double[] extendFactors(double[] factors) {
		int multiple = Constants.getConstants().getMax_trains();
		
		double[] result = new double[factors.length * multiple];
		
		for(int i = 0; i < factors.length; i++) {
			for(int j = 0; j < multiple; j++) {
				result[(i*multiple) + j] = factors[i];
			}
		}
		
		return result;
	}
	
	/**
	 * adds all combinations of r numbers in array arr to the static list above
	 * @param arr the array to search for combinations in
	 * @param data the temporary array to store a combination in
	 * @param start the starting position in the array this time
	 * @param end the ending position in the array this time
	 * @param index the index of the array to start at
	 * @param r the number in integers to make a combination from
	 * @param gr the gear ratio that the combinations must multiply to
	 */
	private void combo(double[] arr, double[] data, int start, int end, int index, int r, double gr) {
		
		//if the combination is full, add it to the list
		if(index == r) {
			//calculates the product of the combination
			double product = 1;
			for(int i = 0; i < data.length; i++) {
				product *= data[i];
			}
			
			//if the product is equal to the gear ratio, add it to the list
			if(product == gr) {
				combos.add(data);
				System.out.println(Util.toString(data));
			}
			
			return;
		}
		
		//replace index with all possible elements.
		//The condition "end-i+1 >= r-index" makes sure that including
		//one element at index will make a combination with remaining
		//elements at remaining positions
		for(int i = start; i <= end && end-i+1 >= r-index; i++) {
			data[index] = arr[i];
			combo(arr, data, i+1, end, index+1, r, gr);
		}
	}
	
	/**
	 * the main function to print all the combinations of an array
	 * @param arr the array to search for combinations in
	 * @param r the amount of numbers in a combination
	 */
	private void findAllCombinations(double[] arr, double gr) {
		double funcGR = Math.round(gr * 100.0) / 100.0;
		System.out.println("Functional Gear Ratio: " + funcGR);
		
		for(int i = 2; i <= Constants.getConstants().getMax_trains(); i++) {
			//a temp array to store all combinations one by one
			double[] data = new double[i];
			
			//store all combinations
			combo(arr, data, 0, arr.length - 1, 0, i, funcGR);
		}
	}

	public int getDesignCount() {
		return designCount;
	}
}
