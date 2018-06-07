package com.cdw.model;

public class Customer {
	private String creditCardNo, state, streetName, country, city,
			       fName, mName, lName, email, zip, aptNo;
	private int phone, ssn;
	
	public String getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "CREDIT_CARD_NO: " + creditCardNo + "\n\n" +
				"FIRST_NAME: " + fName + "\n" +
				"MIDDLE_NAME: " + mName + "\n" +
				"LAST_NAME: " + lName + "\n\n" +
				"PHONE: " + phone + "\n" +
				"EMAIL: " + email + "\n\n" +
				"STREET_NO: " + aptNo + "\n" +
				"STREET_NAME: " + streetName + "\n" +
				"CITY: " + city + "\n" +
				"STATE: " + state + "\n" +
				"ZIP: " + zip + "\n" +
				"COUNTRY: " + country;

	}		
}
