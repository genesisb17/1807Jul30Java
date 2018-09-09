package com.revature.questioneighteen;

public class SubClass extends SuperClass{

	@Override
	public boolean checkUpper(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(!str.equals(str.toLowerCase())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String convertLower(String str) {
		return str.toUpperCase();
	}

	@Override
	public int stringAndTen(String str){
		int num = 10;
        //typecasted string to integer for addition to work
        for(int i = 0; i < str.length(); i++){
            num = num + (int)str.charAt(i);
        }
        return num;
	}
	
}
