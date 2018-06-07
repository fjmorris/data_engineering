package com.cdw.model;

public class Transaction {
	private int id, day, month, year, ssn, branchCode, count;
	private double value;
	private String cardNo, type;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getDay()	{
		return day;
	}
	@Override
	public String toString() {
		// do not include count field
		return "Transaction [id=" + id + ", day=" + day + ", month=" + month + ", year=" + year + ", ssn=" + ssn
				+ ", branchCode=" + branchCode + ", value=" + value + ", cardNo=" + cardNo
				+ ", type=" + type + "]";
	}
	
	
}
