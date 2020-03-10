package utils;

import java.sql.*;

public class DBUtils {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "shubh", "shubham");
	}

}
