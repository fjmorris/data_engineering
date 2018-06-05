package com.cdw.resources;

public class Queries {

	public final static String TRANSACTIONS_BY_ZIPCODE_FOR_MONTH_YEAR = 
			"SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE " +
					"from cdw_sapp.cdw_sapp_creditcard cr " +
					"join cdw_sapp_customer cu on cr.CUST_SSN = cu.SSN " +
					"where cu.cust_zip = ? and cr.month = ? and cr.year = ? " +
					"order by cr.year desc, cr.month desc, cr.day desc, cr.transaction_id asc";

	public final static String TOTAL_BY_TYPE = 
			"select sum(transaction_value), count(*)" +
					"from CDW_SAPP_CREDITCARD " +
					"where TRANSACTION_TYPE = ?";

	public final static String TOTAL_BY_STATE = 
			"select sum(transaction_value), count(*) " +
					"FROM cdw_sapp.cdw_sapp_creditcard cr " + 
					"join cdw_sapp_branch br on cr.BRANCH_CODE = br.BRANCH_CODE " +
					"where br.BRANCH_STATE = ?";

	public final static String GET_CUSTOMER_BY_SSN = "SELECT * FROM CDW_SAPP_CUSTOMER WHERE ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_FIRST_NAME = "update CDW_SAPP_CUSTOMER set FIRST_NAME = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_MIDDLE_NAME = "update CDW_SAPP_CUSTOMER set MIDDLE_NAME = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_LAST_NAME = "update CDW_SAPP_CUSTOMER set LAST_NAME = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_PHONE = "update CDW_SAPP_CUSTOMER set CUST_PHONE = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_EMAIL = "update CDW_SAPP_CUSTOMER set CUST_EMAIL = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_STREET_NO = "update CDW_SAPP_CUSTOMER set APT_NO = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_STREET_NAME = "update CDW_SAPP_CUSTOMER set STREET_NAME = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_CITY = "update CDW_SAPP_CUSTOMER set CUST_CITY = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_STATE = "update CDW_SAPP_CUSTOMER set CUST_STATE = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_ZIP = "update CDW_SAPP_CUSTOMER set CUST_ZIP = ? where ssn = ?";
	
	public final static String MODIFY_CUSTOMER_BY_SSN_COUNTRY = "update CDW_SAPP_CUSTOMER set CUST_COUNTRY = ? where ssn = ?";
		
	public final static String TRANSACTIONS_BY_CREDITCARDNUMBER_FOR_MONTH_YEAR = 
			"SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE " +
					"from cdw_sapp.cdw_sapp_creditcard cr " +
					"where cr.credit_card_no = ? and cr.month = ? and cr.year = ? " +
					"order by cr.year desc, cr.month desc, cr.day desc, cr.transaction_id asc";
	
	public final static String TOTAL_BY_CREDITCARDNUMBER_FOR_MONTH_YEAR = 
			"select sum(transaction_value), count(*)" +
					"from cdw_sapp.cdw_sapp_creditcard cr " +
					"where cr.credit_card_no = ? and cr.month = ? and cr.year = ? " +
					"order by cr.year desc, cr.month desc, cr.day desc, cr.transaction_id asc";

	// added the formatted date field so that null row is not returned
	public final static String TRANSACTIONS_BY_CREDITCARDNUMBER_IN_DATE_RANGE = 
			"SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE " +
					", DATE_FORMAT(CONCAT(CAST(cr.YEAR as char(4)),'-',CAST(cr.MONTH as char(2)),'-',CAST(cr.DAY as char(2))),'%Y-%m-%d') " + 
					"from cdw_sapp.cdw_sapp_creditcard cr " +
					"where cr.credit_card_no = ? " +
					"AND (DATE_FORMAT(CONCAT(CAST(cr.YEAR as char(4)),'-',CAST(cr.MONTH as char(2)),'-',CAST(cr.DAY as char(2))),'%Y-%m-%d') " +
					"BETWEEN DATE_FORMAT( ? ,'%Y-%m-%d') AND DATE_FORMAT( ? ,'%Y-%m-%d') ) " +
					"order by cr.year desc, cr.month desc, cr.day desc, cr.transaction_id asc";
	
	private Queries(){
		/* TO PREVENT NEW INSTANCE OF 'QUERIES' W/ CONSTRUCTOR */
	}
}
