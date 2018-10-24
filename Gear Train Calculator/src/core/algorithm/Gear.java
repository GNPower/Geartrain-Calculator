package core.algorithm;

import core.files.Constants;

public class Gear {

	//extends the array of data by inputing every number x times, where x is the max trains constant
	public int[] createCombinationsData(int[] factorData) {
		int[] comboData = new int[factorData.length * Constants.getConstants().getMax_trains()];
		
		int maxTrains = Constants.getConstants().getMax_trains();
		for(int i = 0; i < comboData.length; i += maxTrains) {
			for(int j = 0; j < maxTrains; j++) {
				comboData[i + j] = factorData[i / maxTrains];
			}
		}
		
		return comboData;
	}
}
