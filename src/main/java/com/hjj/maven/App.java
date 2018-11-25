package com.hjj.maven;

import java.util.UUID;

public class App {
	public static void main(String[] args) {
		App app = new App();
		System.out.println("UniqueKey: " + app.generateUniqueKey());
	}
	
	public String generateUniqueKey(){
		String id = UUID.randomUUID().toString();
		return id;
	}
}
