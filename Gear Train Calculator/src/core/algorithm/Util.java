package core.algorithm;

import java.util.ArrayList;

public class Util {

	public static String[] removeEmptyStrings(String[] data) {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < data.length; i++) {
			if (!data[i].equals(""))
				result.add(data[i]);
		}

		String[] res = new String[result.size()];
		result.toArray(res);

		return res;
	}
	
	public static int[] toIntArray(Integer[] data) {
		int[] result = new int[data.length];
		
		for(int i = 0; i < data.length; i++) {
			result[i] = data[i].intValue();
		}
		
		return result;
	}
	
	public static int[] toIntArray(ArrayList<Integer> data) {
		int[] result = new int[data.size()];
		
		for(int i = 0; i < data.size(); i++) {
			result[i] = data.get(i).intValue();
		}
		
		return result;
	}
	
	public static String toString(int[] data) {
		String result = "[";
		for(int i = 0; i < data.length; i++) {
			result += data[i];
			if(i != data.length - 1)
				result += ", ";
		}
		result += "]";
		
		return result;
	}
	
	public static String toString(double[] data) {
		String result = "[";
		for(int i = 0; i < data.length; i++) {
			result += data[i];
			if(i != data.length - 1)
				result += ", ";
		}
		result += "]";
		
		return result;
	}
	
	public static boolean doesNotContain(ArrayList<double[]> list, double[] data) {
		double hash1 = hash(data);
		
		for(int i = 0; i < list.size(); i++) {
			double hash2 = hash(list.get(i));
			if(hash1 == hash2)
				return false;
		}
		
		return true;
	}
	
	public static double round(double num, int decAccuracy) {
		return Math.round(num * Math.pow(10.0, decAccuracy)) / Math.pow(10.0, decAccuracy);
	}
	
	public static double hash(double[] data) {
		double hash = 0;
		for(int i = 0; i < data.length; i++)
			hash += data[i];
		
		return hash;
	}
}
