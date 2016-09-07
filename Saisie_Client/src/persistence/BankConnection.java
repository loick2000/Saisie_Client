package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {

	private String url = "jdbc:mysql://127.0.0.1:3306/banque";
	private String user = "root";
	private String passwd = "";
	private static Connection connect;

	private BankConnection() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			System.out.println("Erreur lors de la connexion à la base ------------");
			e.printStackTrace();
		}
	}

	public static Connection getInstance() throws ClassNotFoundException {
		if (connect == null) {
			new BankConnection();
		}
		return connect;
	}
}
