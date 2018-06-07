package com.cdw.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Menu {
	
	private String menuName = "MENU";
	private ArrayList<String> optionList;
	protected int optionChoice = 0;
	
	public Menu(String menuName, String[] optionArray) {
		this.menuName = menuName;
		//https://stackoverflow.com/questions/157944/create-arraylist-from-array
		this.optionList = new ArrayList<>(Arrays.asList(optionArray));
	}

	private static void printSeparatorLine () {
		System.out.println("****************************************");
	}
	
	private void printTitle () {
		System.out.println(this.menuName);
	}
	
	private void printOptionList () {
		for (int i = 0; i < this.optionList.size(); i++) { 		      
			System.out.println("(" + (i + 1) + ") " + this.optionList.get(i)); 		
		}
		System.out.println("(0) Exit");
	}
	
	protected void printMenu () {
		printSeparatorLine();
		printTitle();
		printOptionList();
		printSeparatorLine();
	}

	protected void readMenuChoice(Scanner sc) {  
		System.out.print("Please select an option (0-" + this.optionList.size() + "):  ");
		this.optionChoice = sc.nextInt();
		sc.nextLine();
		//System.out.println(this.optionChoice); 	
	}

	abstract void showMenu(Scanner sc);

}
