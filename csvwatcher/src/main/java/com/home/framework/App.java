package com.home.framework;

import com.home.framework.restservices.csvreader.service.PersonService;

public class App {
	
	public static void main(String[] args) {
		PersonService service = new PersonService();
		service.readAndStoreCsv();
		
	}

}
