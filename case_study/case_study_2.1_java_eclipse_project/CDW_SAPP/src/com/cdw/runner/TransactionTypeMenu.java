/*
Functional Requirements
2.1.1 Transaction Details
2) To display the number and total values of transactions for a given type.
*/

package com.cdw.runner;

import java.util.Scanner;

import com.cdw.dao.TransactionDAO;
import com.cdw.model.Transaction;

public class TransactionTypeMenu extends Menu{

	private static String menuName = "TRANSACTION TYPE";
	private static String[] optionArray = { 
			"Education", 
			"Entertainment", 
			"Grocery",
			"Gas", 
			"Bills", 
			"Test", 
			"Healthcare"
		};
	String type;
		
	public TransactionTypeMenu() {
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
		case 1: case 2: case 3: case 4:  case 5: case 6: case 7:
			this.type = optionArray[this.optionChoice - 1];
			break;
		default:
			System.out.println(this.optionChoice + " is not a valid choice.");
		}
	}

	void displayTransactionsTotalByType() {
		//2) To display the number and total values of transactions for a given type.
		// "Display Number and Total Value of Transactions for a Particular Type",		
		TransactionDAO tDAO = new TransactionDAO();
		Transaction trans = tDAO.getTotalByType(this.type);
		System.out.println("For Type: " + this.type + ", Number: " + trans.getCount() + ", Total Value: " + trans.getValue());		
	}

}
