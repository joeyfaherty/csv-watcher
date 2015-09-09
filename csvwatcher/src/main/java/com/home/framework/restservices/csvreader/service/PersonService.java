package com.home.framework.restservices.csvreader.service;

import java.io.FileReader;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

import com.home.framework.jpa.dao.PersonDAO;
import com.home.framework.jpa.model.Person;

public class PersonService {
	
	private PersonDAO personDao;
	
	@Inject
	public void setPersonDaoIml(PersonDAO personDao) {
		this.personDao = personDao;
	}

	public Person readAndStoreCsv() {
		Person person = new Person();
		
		try (CSVReader csvReader = new CSVReader(new FileReader("/Users/joeyfaherty/git/csvwatcher/src/main/resources/Workbook2.csv"))) {
			// read each row of the csv
			String [] row;
			int lineCounter = 1;
			csvReader.readNext();
			while((row = csvReader.readNext()) != null) {
				person = PersonService.populateFromCSV(lineCounter, row);
				if (StringUtils.isEmpty(person.getName())) {
					System.out.println("No name - person name must be present");
				} else {
					personDao.savePerson(person);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		return person;
	}
	
//	public Person readAndStorePrn() throws IOException {
//		Person person = new Person();
//		
//		try(BufferedReader br = new BufferedReader(new FileReader("/Users/joeyfaherty/git/BETestJoey/Workbook2.prn"))) {
//		    StringBuilder sb = new StringBuilder();
//		    String line = br.readLine();
//
//		    while (line != null) {
////		    	String trimedLine = line.trim().replaceAll("\\s+", " ");
//		    	String [] splitList;
//		    	String [] splitAgain;
//		    	splitList = line.split("\\s+\\s+");
//		    	splitAgain = splitList[4].split("\\s+");
////		    	System.out.println(trimedLine);
//		        sb.append(line);
//		        sb.append(System.lineSeparator());
//		        line = br.readLine();
//		    }
//		    String everything = sb.toString();
//		}
//		return person;
//	}
	
	
	
	private final static int COL_NAME = 0;
    private final static int COL_ADDRESS = 1;
    private final static int COL_POSTCODE = 2;
    private final static int COL_PHONE = 3;
	private final static int COL_CREDIT_LIMIT = 4;
    private final static int COL_BIRTHDAY = 5;

	private static Person populateFromCSV(int lineCounter, String[] row) {
		Person person = new Person();
		
		for (int idxCols = 0; idxCols < row.length; idxCols++) {
    		String cell = row[idxCols];
    		try {
				switch (idxCols) {
				case COL_NAME:
					person.setName(cell);
					break;
				case COL_ADDRESS:
					person.setAddress(cell);
					break;
				case COL_POSTCODE:
					person.setPostcode(cell);
					break;
				case COL_BIRTHDAY:
					person.setDateOfBirth(cell);
					break;
				default:
					break;
				}
    		} catch(NumberFormatException nfe) {
    		}
		}
    	return person;
    }
	
	
}
	
