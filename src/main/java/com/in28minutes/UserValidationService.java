package com.in28minutes;

public class UserValidationService {
	
	public boolean isUserValid(String user, String password) {
		
		if (user.equals("testuser") && password.equals("dummy")) {
			
			return true;
		}else {
			return false;
		}
	}

}
