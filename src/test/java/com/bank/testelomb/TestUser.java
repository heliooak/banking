package com.bank.testelomb;

public class TestUser {

	public static void main(String[] args) {
		
		User u1 = new User();
		
		u1.setName("João");
		u1.setAge(25);
		
		System.out.println(u1.getName() + " " + u1.getAge());
		
	}
	
}
