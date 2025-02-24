package com.devops.demo.model;


	
	public class Validate {
	    public static boolean isPasswordValid(User user) {
	        if (user.getPassword() == null || user.getValidatePassword() == null) {
	            return false; // If either password is null, return false
	        }
	        return user.getPassword().equals(user.getValidatePassword()); // Compare passwords
	    }
	}

	
	
	
