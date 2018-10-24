package core;

import core.files.Constants;
import core.files.Reader;

public class Main {

	public static void main(String[] args) {

		Reader.readConstraints("./res/constraints.txt");
		Constants.getConstants().printConstants();
    
		System.out.println("Hello Graham. This is a test.")
	}

}
