package com.cdw.runner;

import java.util.Scanner;

public class MainMenu extends Menu{

	private static String menuName = "MAIN MENU";
	private static String[] optionArray = {
			"Display Transaction Details",
			"Display/Update Customer Details"
			};
	
	public MainMenu() {
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
			TransactionMenu tMenu = new TransactionMenu();
			tMenu.showMenu(sc);
			break;
		case 2:
			CustomerMenu cMenu = new CustomerMenu();
			cMenu.showMenu(sc);
			break;
		default:
			System.out.println(this.optionChoice + " is not a valid choice.");
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Menu menu = new MainMenu();
		menu.showMenu(sc);
		sc.close();
	}

}
