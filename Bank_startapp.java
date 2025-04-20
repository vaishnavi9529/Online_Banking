package Bank_mang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bank_startapp {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        System.out.println("*******WELCOME TO BANK MANGMENT SYSTEM******* ");
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        while (true) {
	        	System.out.println("1. Create Customer Account");
	            System.out.println("2. Insert Customer Records");
	            System.out.println("3. Withdraw amount from customer Records");
	            System.out.println("4. Deposit amount in customer Records");
	            System.out.println("5. Check balance from Customer Records");
	            System.out.println("6. Exit Application");
	            
	            System.out.println("Select Operation ");
	            int op = Integer.parseInt(br.readLine());

	            if (op == 1) {
	            	
	                boolean success = Customer_deo.createBankAppTable();

	                if (success) {
	                    System.out.println("Bank_App table created successfully");
	                } else {
	                    System.out.println("Failed to create Bank_App table");
	                }
	            }

	            else if (op == 2) {
	            	
	            	 System.out.println("Enter customer name : ");
	                 String name = br.readLine();

	                 System.out.println("Enter customer balance : ");
	                 double balance = Double.parseDouble(br.readLine());

	                 System.out.println("Enter customer account type : ");
	                 String account_type = br.readLine();
	                 
	                 Customer cust = new Customer(name,balance,account_type);
	                 
	                 boolean success = Customer_deo.insertCustomer(cust);
	                 
	                 if(success)
	                 {
	                	 System.out.println("Customer added successfully");
	                 }
	                 else
	                 {
	                	 System.out.println("Fail to add customer");
	                 }
	                 
	            } 
	            
	            else if (op == 3) {
	            	
	            	System.out.println("Enter customer id : ");
	            	int id = Integer.parseInt(br.readLine());
	            	
	            	System.out.println("Enter amount to withdraw: ");
	                double amount = Double.parseDouble(br.readLine());

	            	
					boolean success = Customer_deo.withdrawCustomer(id, amount);
	            	if(success)
	            	{
	            		System.out.println("Withdraw successful......");
	            	}
	            	else
	            	{
	            		System.out.println("Fail to withdraw amount ...");
	            	}
	            }
	            
	            else if (op == 4) {
	            	
	            	    System.out.println("Enter customer Id : ");
	            	    int customerId = Integer.parseInt(br.readLine());

	            	    System.out.println("Enter amount to deposit : ");
	            	    double amount = Double.parseDouble(br.readLine());

	            	    boolean success = Customer_deo.depositCustomer(customerId, amount);

	            	    if (success) {
	            	        System.out.println("Deposit successful");
	            	    } else {
	            	        System.out.println("Failed to deposit amount");
	            	    }
	            	}
	            
	            
	            else  if (op == 5) {
	            	
	                System.out.println("Enter customer ID : ");
	                int customerId = Integer.parseInt(br.readLine());

	                double balance = Customer_deo.checkBalance(customerId);

	                if (balance != -1) {
	                    System.out.println("Customer balance: " + balance);
	                } else {
	                    System.out.println("Failed to retrieve balance.");
	                }
	            }

	            else if (op == 6) {
	            	
	                System.out.println("Exiting application...");
	                break;
	            } 
	            else {
	                System.out.println("Invalid operation. Please select a valid option.");
	            }
	            
	            System.out.println("........THANK YOU VISIT AGAIN!!!........");
	        }
	    }
	}

