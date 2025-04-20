package Bank_mang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer_deo {
	
	public static boolean insertCustomer(Customer cust)
	{
		boolean f = false;
		try {
			Connection con = Bp.createC();
			
			String q1 = "insert into Bank_App(cname , cbalance, cacc_type) values (? , ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(q1);
			
			pstmt.setString(1 , cust.getCustomerName());
			pstmt.setDouble(2 , cust.getCustomerBalance());
			pstmt.setString(3 , cust.getCustomer_AccountType());
			pstmt.executeUpdate();
			f = true;
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return(f);
	}
	
	public static boolean withdrawCustomer(int cid, double amount)
	{
		    boolean f = false;
		    try {
		        Connection con = Bp.createC();
		        
		        // Check if the customer has sufficient balance
		        String q1 = "select cbalance from Bank_App where cid = ?";
		        PreparedStatement pstmt = con.prepareStatement(q1);
		        pstmt.setInt(1, cid);
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
		            double currentBalance = rs.getDouble("cbalance");
		            if (currentBalance >= amount) {
		                // Update the balance
		                String q2 = "update Bank_App set cbalance = cbalance - ? where cid = ?";
		                PreparedStatement pstmt2 = con.prepareStatement(q2);
		                pstmt2.setDouble(1, amount);
		                pstmt2.setInt(2, cid);
		                pstmt2.executeUpdate();
		                f = true;
		            } else {
		                System.out.println("Insufficient balance.");
		            }
		        }
		        con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return (f);
	}

	public static boolean depositCustomer(int cid, double amount) {
	    boolean f = false;
	    try {
	        Connection con = Bp.createC();
	        
	        // Update the balance
	        String q1 = "update Bank_App set cbalance = cbalance + ? where cid = ?";
	        PreparedStatement pstmt = con.prepareStatement(q1);
	        pstmt.setDouble(1, amount);
	        pstmt.setInt(2, cid);
	        pstmt.executeUpdate();
	        f = true;
	        
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return (f);
	}

	public static double checkBalance(int customerId) {
		 double balance = -1;
		    try {
		        Connection con = Bp.createC();
		        
		        // Query to get the balance
		        String q1 = "select cbalance from Bank_App where cid = ?";
		        PreparedStatement pstmt = con.prepareStatement(q1);
		        pstmt.setInt(1, customerId);
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
		            balance = rs.getDouble("cbalance");
		        } else {
		            System.out.println("Customer not found.");
		        }
		        
		        con.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		return 0;
	}

	public static boolean createBankAppTable() {
		boolean f = false;
	    try {
	        Connection con = Bp.createC();
	        
	        String q1 = "CREATE TABLE Bank_App (" +
                    "cid INT PRIMARY KEY AUTO_INCREMENT, " +
                    "cname VARCHAR(100), " +
                    "cbalance DOUBLE, " +
                    "cacc_type VARCHAR(50)" +
                    ")";
	        
	        Statement stmt = con.createStatement();
	        stmt.executeUpdate(q1);
	        f = true;
	        
	        con.close();
	    } catch (Exception e) {
	    	//System.out.println("Error: " + e.getMessage());
	        e.printStackTrace();
	    }
	
		
		return false;
	}
}


	

