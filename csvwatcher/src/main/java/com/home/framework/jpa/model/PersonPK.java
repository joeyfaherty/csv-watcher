package com.home.framework.jpa.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PersonPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 823299114700434241L;

	private String name;
	
	private String postcode;
	
	private String dateOfBirth;
	
	public PersonPK() {
		super();
	}

	public PersonPK(String name, String postcode, String dateOfBirth) {
		super();
		this.name = name;
		this.postcode = postcode;
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(postcode).append(dateOfBirth).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
			
		PersonPK personPk = (PersonPK) obj;
		return new EqualsBuilder()
					.appendSuper(super.equals(obj))
					.append(name, personPk.getName())
					.append(postcode, personPk.getPostcode())
					.append(dateOfBirth, personPk.getDateOfBirth())
					.isEquals();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
