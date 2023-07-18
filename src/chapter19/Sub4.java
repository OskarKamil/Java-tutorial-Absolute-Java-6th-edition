package chapter19;
/*
 * Alternatively you can use SQLite which is a lighter version of SQL. In SQLite a database is a file instead a server.
 */

/*
 * Note that to run this code you need the database file in the right directory and installed all software and jar library to use mySQL. Running this code on your device will most likely fail, so just examine this code without running it.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Sub4 {
	/*
	 * This is a very broad topic but we will show only the beginning. SQL is its
	 * own topic and language and deserves a separate tutorial.
	 * 
	 * First you need to download MySQL. Go to their website, go to downloads, go to
	 * GPL and download free version. Best way is to download MySQL installer.
	 * Download it, install it. Go through with steps by default settings. Choose
	 * first option of installation type. Leave everything by default.
	 * 
	 * During installation you will have to create a root user. It is a main
	 * administrator of the database. Then you create a database and its user.
	 * 
	 * At the end of installation it will ask if you want to create windows
	 * process/service. Select no. Otherwise it will start up with system start up.
	 * Exit configuration, the rest is irrelevant.
	 * 
	 * Next open MySQL workbench. This is a main program that you will use to
	 * interact with your database.
	 * 
	 * You will see a home page. To access the database you need to create a
	 * connection to it. Leave everything by default as the same. You should name
	 * your connection to the database. You can simply name it connection.
	 * 
	 * Then you will see a page of your database. Quickly run a query to create new
	 * table, with columns. Then query insert into table and fill up the table with
	 * value. After your table is created you can close the MySQL workbench and go
	 * here. We will retrieve data from that table using eclipse and java.
	 * 
	 * But first you need to open properties of this project. Go into build path >
	 * libraries and open import external jar. Go to C/program files x86 and go to
	 * MySQL and find connector J. And choose the jar file. Now you just imported a
	 * library that will let us access the database by using SQL queries.
	 */
	public static void main(String[] args) {
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/justtest";
		String username = "oskar";
		String password = "dogsarecute11";
		/*
		 * We need to create Connection object that will be used to connect to out
		 * database. And String objects. url is address of our database, our database is
		 * local, but other databases are on the Internet in the server, username is
		 * username and password is a password. When creating a database, apart from
		 * root user, you also need database users, each user is an employee for
		 * example. Here you enter your credentials.
		 */

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			 * Driver to connect to the database.
			 */

			con = DriverManager.getConnection(url, username, password);
			/*
			 * Connecting to the database using our credentials and url of database.
			 */

			System.out.println("Connected!");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students;");
			ResultSetMetaData rsmd1 = (ResultSetMetaData) rs.getMetaData();
			int columnsNumber1 = rsmd1.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber1; i++) {
					System.out.print(rs.getString(i) + " ");
				}
				System.out.println();
			}
			/*
			 * These lines are pretty self explanatory. This code prints all columns and
			 * rows from students table.
			 */

		} catch (SQLException | ClassNotFoundException ex) {
			throw new Error("Error ", ex);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}