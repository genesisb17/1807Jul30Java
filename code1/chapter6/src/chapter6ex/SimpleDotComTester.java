package chapter6ex;

public class SimpleDotComTester {

	public static void main(String[] args) {

		DotCom dot = new DotCom();
		
		int[] locations = {2,3,4};
		dot.setLocationCells(locations);
		String userGuess = "2";
		String result =  dot.checkYourself(userGuess);
		String testResult = "failed";
		if(result.equals("hit")) {
			testResult = "Passed";
		}
		System.out.println(testResult);
	}

}
