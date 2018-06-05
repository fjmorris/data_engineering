/*
Functional Requirements
2.1.1 Transaction Details
1) To display the transactions made by customers living in a given zipcode for a given month and year. Order by day in descending order.
2) To display the number and total values of transactions for a given type.
3) To display the number and total values of transactions for branches in a given state
*/

package com.cdw.runner;

import java.util.ArrayList;
import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;

public class TransactionMenu extends Menu{

	private static String menuName = "TRANSACTION DETAILS";
	private static String[] optionArray = { 
			"Display Transactions by Customers in a Particular Zipcode",
			"Display Number and Total Value of Transactions for a Particular Type",
			"Display Number and Total Value of Transactions for Branches in a Particular State"
		};

	private String zipcode = null;
	private int month = 0;
	private int year = 0;
	private String state = null;
	
	public TransactionMenu() {
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
			//1) To display the transactions made by customers living in a given zipcode for a given month and year. Order by day in descending order.
			readZipCode(sc);
			readMonthYear(sc);
			displayTransactionsByZipcodeForMonthYear();
			break;
		case 2:
			//2) To display the number and total values of transactions for a given type.			
			TransactionTypeMenu ttMenu = new TransactionTypeMenu();
			ttMenu.showMenu(sc);
			ttMenu.displayTransactionsTotalByType();
			break;
		case 3:			
			//3) To display the number and total values of transactions for branches in a given state
			readState(sc);
			displayTransactionsTotalByState();
			break;
		default:
			System.out.println(this.optionChoice + " is not a valid choice.");
		}
	}
	
	private void readZipCode(Scanner sc) {  
		System.out.print("Please enter a 5 digit zipcode:  ");
		this.zipcode = sc.next();
		sc.nextLine();
		//System.out.println(this.zipcode); 	
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
	
	private void displayTransactionsByZipcodeForMonthYear() {
		//1) To display the transactions made by customers living in a given zipcode for a given month and year. Order by day in descending order.
		// "Display Transactions by Customers in a Particular Zipcode",		
		TransactionDAO tDAO = new TransactionDAO();
		ArrayList<Transaction> transactions = tDAO.getTransactionsByZipCodeForMonthYear(this.zipcode,this.month,this.year);
	        
		for(Transaction tr : transactions) {
			System.out.println(tr.toString());
		}		
	}
	
	private void readState(Scanner sc) {  
		System.out.print("Please enter a 2 character state code:  ");
		this.state = sc.next().substring(0,2).toUpperCase();
		sc.nextLine();
		//System.out.println(this.state); 	
	}

	private void displayTransactionsTotalByState() {
		//3) To display the number and total values of transactions for branches in a given state
		//"Display Number and Total Value of Transactions for Branches in a Particular State"		
		TransactionDAO tDAO = new TransactionDAO();
		Transaction trans = tDAO.getTotalByState(this.state);
		System.out.println("For State: " + this.state + ", Number: " + trans.getCount() + ", Total Value: " + trans.getValue());		
	}

}
