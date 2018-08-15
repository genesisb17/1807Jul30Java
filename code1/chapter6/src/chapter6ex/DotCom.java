package chapter6ex;

import java.util.ArrayList;

public class DotCom {
	
	public String fb = "fb.com";
	public String ig = "ig.com";
	public String goog = "google.com";
	
	
	private ArrayList <String> locationCells;
//	int numOfHits;

	public void setLocationCells(ArrayList<String> loc) {

		
		locationCells = loc;
	}
	
	
	public String checkYourself(String userInput) {
		
		String result = "miss";
		
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			locationCells.remove(index);
		}
		
		if (locationCells.isEmpty()) {
			result = "kill";
		} else {
			result = "hit";
		}
		return result;
		
	}
}