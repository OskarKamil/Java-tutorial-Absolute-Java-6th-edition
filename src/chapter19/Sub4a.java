package chapter19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sub4a {
	/*
	 * This is an example of how to connect to SQLite database. SQLite is a lighter
	 * version of mySQL. SQLite offers database which are portable and easy to
	 * manage without server, configuration etc. In order to use SQLite you also
	 * need a driver which is added to the java build path of this project. It is
	 * most likely this code will not run on your device unless you modify the code
	 * or add jar yourself. For sake of this lesson, simply examine the code instead
	 * of running it.
	 */
	public static void main(String[] args) {
		Sub4a app = new Sub4a();
		app.selectAll();
	}

	public void selectAll() {
		/*
		 * A method that displays whole students table.
		 */

		String sql = "SELECT * FROM students";
		/*
		 * SQL query.
		 */

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * If you want to retrieve data from database file, you need to wrap it around
	 * try and catch blocks. That's logical, same thing you do when reading from
	 * text file. You never know if the filename is correct or the pathname is
	 * correct. Same with database. And each time you want to read from database, or
	 * even make changes, you need to create a connection, and then execute SQL
	 * query. After that simply do what you want to do next, display the data etc.
	 */

	private Connection connect() {
		String url = "jdbc:sqlite:D:/GPs/Java/JavaProjects/Absolute Java 6th/testdatabase.db/";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}