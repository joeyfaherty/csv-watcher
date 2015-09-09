package com.home.framework.jpa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="person", schema="test")
@IdClass(PersonPK.class)
public class Person implements Serializable {
	
	@Id
	@Column(name="namee")
	private String name;
	
	@Id
	@Column(name="pc")
	private String postcode;
	
	@Id
	@Column(name="dob")
	private String dateOfBirth;
	
	@Basic
	@Column(name="addd")
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}

