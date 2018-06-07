/*
Functional Requirements
2.1.2 Customer Details
1) To check the existing account details of a customer.
2) To modify the existing account details of a customer
3) To generate monthly bill for a credit card number for a given month and year.
4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order.
*/

package com.cdw.runner;

import java.util.ArrayList;
import java.util.Scanner;

import com.cdw.dao.CustomerDAO;
import com.cdw.dao.TransactionDAO;
import com.cdw.model.Customer;
import com.cdw.model.Transaction;

public class CustomerMenu extends Menu{

	private static String menuName = "CUSTOMER DETAILS";
	private static String[] optionArray = { 
			"Display Customer Details",
			"Modify Customer Details",
			"Generate Monthly Bill for a Particular Credit Card",
			"Display Customer Transactions"
		};

	private int ssn = 0;
	private String creditCardNumber;
	private String fieldName;
	private String fieldValue;
	private int month = 0;
	private int year = 0;
	private int[] startDate = {1,1,2000};
	private int[] endDate = {1,1,2000};
	
	public CustomerMenu() {
		super(menuName, optionArray);
	}

	@Override
	void showMenu(Scanner sc) {

		printMenu();
		readMenuChoice(sc);
		switch(this.optionChoice) {
		case 0:
			System.out.println("Thank you for using the credit card system.");
			break;
		case 1:
			//1) To check the existing account details of a customer.
			//Display Customer Details
			readSsn(sc);
			displayCustomerBySsn();
			break;
		case 2:
			//2) To modify the existing account details of a customer
			//Modify Customer Details
			readSsn(sc);
			displayCustomerBySsn();
			readModifiedField(sc);
			modifyCustomerBySsn();
			displayCustomerBySsn();
			break;
		case 3:
			//3) To generate monthly bill for a credit card number for a given month and year.			
			//Generate Monthly Bill for a Particular Credit Card
			readCreditCardNumber(sc);
			readMonthYear(sc);
			displayTransactionsByCreditCardNumberForMonthYear();
			displayTransactionsTotalByCreditCardNumberForMonthYear();
			break;
		case 4:
			//4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order.
			//Display Customer Transactions
			readCreditCardNumber(sc);			
			readStartDate(sc);
			readEndDate(sc);
			displayTransactionsByCreditCardNumberInDateRange();
			break;
		default:
			System.out.println(this.optionChoice + " is not a valid choice.");
		}
	}
	
	private void readSsn(Scanner sc) {
		System.out.print("Please enter a 9 digit Social Security Number:  ");
		this.ssn = Integer.parseInt(sc.next());
		sc.nextLine();
		//System.out.println(this.zipcode); 	
	}
	
	private void displayCustomerBySsn() {
		//int ssn = 123451602;	
		CustomerDAO cDAO = new CustomerDAO();
		Customer cust = cDAO.getCustomerBySSN(ssn);		
		System.out.println(cust.toString());
	}
	
	private void readModifiedField(Scanner sc) {
		System.out.print("\nPlease enter the name of the contact field you wish to modify: ");
		this.fieldName = sc.next().toUpperCase();
		sc.nextLine();
		//System.out.println(this.fieldName);
		System.out.print("Please enter the new value of that field: ");
		this.fieldValue = sc.next();
		sc.nextLine();
		//System.out.println(this.fieldValue); 	
	}
	
	private void modifyCustomerBySsn() {
		CustomerDAO cDAO = new CustomerDAO();
		cDAO.modifyCustomerBySSN(ssn,this.fieldName,this.fieldValue);				
	}

	private void readCreditCardNumber(Scanner sc) {
		System.out.print("Please enter a 16 digit credit card number:  ");
		this.creditCardNumber = sc.next().substring(0,16);
		sc.nextLine();
		//System.out.println(this.creditCardNumber); 	
	}

	private void readMonthYear(Scanner sc) {
		System.out.print("Please enter a month (1-12):  ");
		this.month = Integer.parseInt(sc.next());
		sc.nextLine();
		System.out.print("Please enter a 4 digit year:  ");
		this.year = Integer.parseInt(sc.next());
		sc.nextLine();
		//System.out.println(this.month + "-" + this.year); 	
	}
	
	private void displayTransactionsByCreditCardNumberForMonthYear() {
		// 4210653310061055
		// 12-2018
		TransactionDAO tDAO = new TransactionDAO();
		ArrayList<Transaction> transactions = tDAO.getTransactionsByCreditCardNumberForMonthYear(this.creditCardNumber,this.month,this.year);	        
		for(Transaction tr : transactions) {
			System.out.println(tr.toString());
		}						
	}
	
	private void displayTransactionsTotalByCreditCardNumberForMonthYear() {
		TransactionDAO tDAO = new TransactionDAO();
		Transaction trans = tDAO.getTotalByCreditCardNumberForMonthYear(this.creditCardNumber,this.month,this.year);
		System.out.println("For Credit Card Number: " + this.creditCardNumber + ", Number: " + trans.getCount() + ", Total Value: " + trans.getValue());		
	}

	private void readStartDate(Scanner sc) {
		System.out.println("For start date,");
		System.out.print("Please enter a month (1-12):  ");
		this.startDate[0] = Integer.parseInt(sc.next());
		sc.nextLine();
		System.out.print("Please enter a day (1-31):  ");
		this.startDate[1] = Integer.parseInt(sc.next());
		sc.nextLine();
		System.out.print("Please enter a 4 digit year:  ");
		this.startDate[2] = Integer.parseInt(sc.next());
		sc.nextLine();
		//System.out.println(Arrays.toString(this.startDate));
	}

	private void readEndDate(Scanner sc) {
		System.out.println("For end date,");
		System.out.print("Please enter a month (1-12):  ");
		this.endDate[0] = Integer.parseInt(sc.next());
		sc.nextLine();
		System.out.print("Please enter a day (1-31):  ");
		this.endDate[1] = Integer.parseInt(sc.next());
		sc.nextLine();
		System.out.print("Please enter a 4 digit year:  ");
		this.endDate[2] = Integer.parseInt(sc.next());
		sc.nextLine();
		//System.out.println(Arrays.toString(this.endDate)); 	
	}

	private void displayTransactionsByCreditCardNumberInDateRange() {
		// 4210653383230786
		// 2018-12-01 AND 2018-12-10
		TransactionDAO tDAO = new TransactionDAO();
		ArrayList<Transaction> transactions = tDAO.getTransactionsByCreditCardNumberInDateRange(this.creditCardNumber,this.startDate,this.endDate);	        
		for(Transaction tr : transactions) {
			System.out.println(tr.toString());
		}						
	}

}

