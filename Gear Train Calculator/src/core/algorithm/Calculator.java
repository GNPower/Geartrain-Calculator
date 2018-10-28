package core.algorithm;

import java.util.ArrayList;

import core.files.Reader;

public class Calculator {
	
	ArrayList<Design> designs;
	
	Reader reader;
	
	String constraintsFile, designFile;
	int designCount = 0;

	public Calculator(String constraintsFile, String designFile) {
		designs = new ArrayList<Design>();
		reader = new Reader();
		this.constraintsFile = constraintsFile;
		this.designFile = designFile;
	}
	
	public void loadData() {	
		Reader.readConstraints(constraintsFile);
		
		reader.readSpecifications(designFile);
		designCount = reader.getSpecifications().size();
	}
	
	public void design(int designIndex) {
		if (designIndex > 0) {
			createDesign(designIndex - 1);
		}else {
			for(int i = 0; i < designCount; i++) {
				createDesign(i);
			}
		}
	}
	
	private void createDesign(int index) {
		
	}
	
	public int getDesignCount() {
		return designCount;
	}
}
