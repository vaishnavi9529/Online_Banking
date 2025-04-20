package Bank_mang;

import java.sql.Connection;
import java.sql.DriverManager;

public class Bp {
	static Connection con;

	public static Connection createC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/ssvps";
			String user="root";
			String password="Vaish@08";
	        con= DriverManager.getConnection(url,user,password);

	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;

}

	
}

	
