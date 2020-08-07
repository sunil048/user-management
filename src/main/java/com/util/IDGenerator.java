package com.util;

public class IDGenerator {

	public static Long generateUserId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Long generateTaskId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}

}
