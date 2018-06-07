package com.cdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cdw.model.Transaction;
import com.cdw.resources.Queries;

public class TransactionDAO extends AbstractDAO {

	public ArrayList<Transaction> getTransactionsByZipCodeForMonthYear(String zipcode, int month, int year) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		establishConnection();
		String query = Queries.TRANSACTIONS_BY_ZIPCODE_FOR_MONTH_YEAR;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, zipcode);
			state.setInt(2, month);
			state.setInt(3, year);
			//System.out.println(state.toString());
			result = state.executeQuery();
			
			while (result.next()){

				//SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE "
				Transaction transaction = new Transaction();
				transaction.setId(result.getInt(1));
				transaction.setDay(result.getInt(2));
				transaction.setMonth(result.getInt(3));
				transaction.setYear(result.getInt(4));
				transaction.setCardNo(result.getString(5));
				transaction.setSsn(result.getInt(6));
				transaction.setBranchCode(result.getInt(7));
				transaction.setType(result.getString(8));
				transaction.setValue(result.getDouble(9));
				
				//System.out.println(transaction.toString());
				transactions.add(transaction);
				
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;						
	}

	public Transaction getTotalByType(String type) {
		Transaction transaction = null;
		establishConnection();
		String query = Queries.TOTAL_BY_TYPE;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, type);
			result = state.executeQuery();
			
			if(result.next())
			{
				transaction = new Transaction();

				double value = result.getDouble(1);
				int count = result.getInt(2);
				
				transaction.setValue(value);
				transaction.setCount(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}

	public Transaction getTotalByState(String type) {
		Transaction transaction = null;
		establishConnection();
		String query = Queries.TOTAL_BY_STATE;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, type);
			result = state.executeQuery();
			
			if(result.next())
			{
				transaction = new Transaction();

				double value = result.getDouble(1);
				int count = result.getInt(2);
				
				transaction.setValue(value);
				transaction.setCount(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}

	public ArrayList<Transaction> getTransactionsByCreditCardNumberForMonthYear(String creditCardNumber, int month, int year) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		establishConnection();
		String query = Queries.TRANSACTIONS_BY_CREDITCARDNUMBER_FOR_MONTH_YEAR;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, creditCardNumber);
			state.setInt(2, month);
			state.setInt(3, year);
			//System.out.println(state.toString());
			result = state.executeQuery();
			
			while (result.next()){

				//SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE "
				Transaction transaction = new Transaction();
				transaction.setId(result.getInt(1));
				transaction.setDay(result.getInt(2));
				transaction.setMonth(result.getInt(3));
				transaction.setYear(result.getInt(4));
				transaction.setCardNo(result.getString(5));
				transaction.setSsn(result.getInt(6));
				transaction.setBranchCode(result.getInt(7));
				transaction.setType(result.getString(8));
				transaction.setValue(result.getDouble(9));
				
				//System.out.println(transaction.toString());
				transactions.add(transaction);
				
			}
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;						
	}	
	
	public Transaction getTotalByCreditCardNumberForMonthYear(String creditCardNumber, int month, int year) {
		Transaction transaction = null;
		establishConnection();
		String query = Queries.TOTAL_BY_CREDITCARDNUMBER_FOR_MONTH_YEAR;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, creditCardNumber);
			state.setInt(2, month);
			state.setInt(3, year);
			//System.out.println(state.toString());
			result = state.executeQuery();
			
			if(result.next())
			{
				transaction = new Transaction();

				double value = result.getDouble(1);
				int count = result.getInt(2);
				
				transaction.setValue(value);
				transaction.setCount(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transaction;
	}
	
	public ArrayList<Transaction> getTransactionsByCreditCardNumberInDateRange(String creditCardNumber, int[] startDate,
			int[] endDate) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		establishConnection();
		String query = Queries.TRANSACTIONS_BY_CREDITCARDNUMBER_IN_DATE_RANGE;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, creditCardNumber);
			state.setString(2, Integer.toString(startDate[2]) + "-" + Integer.toString(startDate[0]) + "-" + Integer.toString(startDate[1]));
			state.setString(3, Integer.toString(endDate[2]) + "-" + Integer.toString(endDate[0]) + "-" + Integer.toString(endDate[1]));
			System.out.println(state.toString());
			result = state.executeQuery();

			while (result.next()){

				//SELECT cr.TRANSACTION_ID, cr.DAY, cr.MONTH, cr.YEAR, cr.CREDIT_CARD_NO, cr.CUST_SSN, cr.BRANCH_CODE, cr.TRANSACTION_TYPE, cr.TRANSACTION_VALUE "
				Transaction transaction = new Transaction();
				transaction.setId(result.getInt(1));
				transaction.setDay(result.getInt(2));
				transaction.setMonth(result.getInt(3));
				transaction.setYear(result.getInt(4));
				transaction.setCardNo(result.getString(5));
				transaction.setSsn(result.getInt(6));
				transaction.setBranchCode(result.getInt(7));
				transaction.setType(result.getString(8));
				transaction.setValue(result.getDouble(9));

				//System.out.println(transaction.toString());
				transactions.add(transaction);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;						
	}	

}
