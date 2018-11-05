package core.math;

public class Fraction {

	private int numerator, denominator;
	
	public Fraction(double x) {
		String a = "" + x;
		String splits[] = a.split("\\.");
		int b = splits[1].length();
		
		int denominator = (int) Math.pow(10, b);
		int numerator = (int) (x * denominator);
		
		int gcd = getGCD(numerator, denominator);
		
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}
	
	public void multiply(int n) {
		numerator *= n;
		denominator *= n;
	}
	
	public void reduce() {
		int gcd = getGCD(numerator, denominator);
		numerator /= gcd;
		denominator /= gcd;
	}
	
	private int getGCD(int n1, int n2) {
		if(n2 == 0)
			return n1;
		return getGCD(n2, n1 % n2);
	}
	
	@Override
	public String toString() {
		return String.valueOf(numerator) + "/" + String.valueOf(denominator);
	}
}
