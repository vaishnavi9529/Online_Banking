package Bank_mang;

public class Customer {
	private int customerId;
	private String customerName;
	private double customerBalance;
	private String customer_AccountType;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public double getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	public String getCustomer_AccountType() {
		return customer_AccountType;
	}
	public void setCustomer_AccountType(String customer_AccountType) {
		this.customer_AccountType = customer_AccountType;
	}
	
	
	public Customer(int customerId, String customerName, double customerBalance, String customer_AccountType) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerBalance = customerBalance;
		this.customer_AccountType = customer_AccountType;
	}
	public Customer(String name, double balance, String account_type) {
		super();
	}
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerBalance="
				+ customerBalance + ", customer_AccountType=" + customer_AccountType + "]";
	}
	
	
}
