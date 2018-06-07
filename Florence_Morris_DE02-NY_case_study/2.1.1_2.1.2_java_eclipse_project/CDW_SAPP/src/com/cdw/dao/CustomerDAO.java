package com.cdw.dao;

import java.sql.SQLException;

import com.cdw.model.Customer;
import com.cdw.resources.Queries;

public class CustomerDAO extends AbstractDAO {
	public Customer getCustomerBySSN(int ssn) {
		Customer customer = null;
		establishConnection();
		String query = Queries.GET_CUSTOMER_BY_SSN;
		try {
			state = conn.prepareStatement(query);
			state.setInt(1, ssn);
			
			result = state.executeQuery();
			if(result.next()) {
				/*
				Column Names (In Order):
				FIRST_NAME,
    			MIDDLE_NAME,
    			LAST_NAME,
			    SSN,
			    CREDIT_CARD_NO,
			    APT_NO,
			    STREET_NAME,
			    CUST_CITY,
			    CUST_STATE,
			    CUST_COUNTRY,
			    CUST_ZIP,
			    CUST_PHONE,
			    CUST_EMAIL
				 */

				// Initialize new Customer object
				customer = new Customer();
				
				// Getting the values; the index from the ResultSet matches the order of columns
				// from the db
				String fName = result.getString(1);
				String mName = result.getString(2);
				String lName = result.getString(3);
				// int social = result.getInt(4); // This is optional, since db has the same value as the parameter from method signature
				String creditCardNo = result.getString(5);
				String aptNo = result.getString(6);
				String streetName = result.getString(7);
				String city = result.getString(8);
				String state = result.getString(9);
				String country = result.getString(10);
				String zip = result.getString(11);
				int phone = result.getInt(12);
				String email = result.getString(13);

				// Setting values in the "customer" object
				customer.setfName(fName);
				customer.setmName(mName);
				customer.setlName(lName);
				customer.setSsn(ssn);
				customer.setCreditCardNo(creditCardNo);
				customer.setAptNo(aptNo);
				customer.setStreetName(streetName);
				customer.setCity(city);
				customer.setState(state);
				customer.setCountry(country);
				customer.setZip(zip);
				customer.setPhone(phone);
				customer.setEmail(email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	public void modifyCustomerBySSN(int ssn, String fieldName, String fieldValue) {
		boolean valid = true;
		establishConnection();
		String query;
		try {
			switch(fieldName) {
			case "FIRST_NAME":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_FIRST_NAME;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "MIDDLE_NAME":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_MIDDLE_NAME;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "LAST_NAME":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_LAST_NAME;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "PHONE":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_PHONE;
				state = conn.prepareStatement(query);
				state.setInt(1, Integer.parseInt(fieldValue));
				state.setInt(2, ssn);
				break;
			case "EMAIL":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_EMAIL;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "STREET_NO":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_STREET_NO;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "STREET_NAME":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_STREET_NAME;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "CITY":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_CITY;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "STATE":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_STATE;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "ZIP":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_ZIP;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				state.setInt(2, ssn);
				break;
			case "COUNTRY":
				query = Queries.MODIFY_CUSTOMER_BY_SSN_COUNTRY;
				state = conn.prepareStatement(query);
				state.setString(1, fieldValue);
				break;
			default:
				System.out.println(fieldName + " is not a valid choice.");
				valid = false;
			}
			
			if ( valid == true ) {
				//System.out.println(state.toString());
				state.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}