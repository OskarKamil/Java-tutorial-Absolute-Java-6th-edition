package chapter19;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Sub2 {
	/*
	 * Don't try to run this code until you read Sub2a.java completely.
	 */
	
	public static void main(String[] args) {
		Date now = new Date();
		/*
		 * Date is a class of a date. Making an object of Date class with empty
		 * constructor will create an object that represents current date and time. To
		 * return that value simply use method toString() which represents text form of
		 * the current date and time. Of course this class has other methods that can
		 * set how the date is represented.
		 */

		try {
			System.out.println("Waiting for a connection on port 7654.");
			ServerSocket serverSocket = new ServerSocket(7654);
			Socket connectionSocket = serverSocket.accept();

			BufferedReader clientInput = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream clientOutputStream = new DataOutputStream(connectionSocket.getOutputStream());

			System.out.println("Connection made, waiting for a client to send thier name.");
			String clientText = clientInput.readLine();
			String replyText = "Welcome, " + clientText + ", Today is " + now.toString() + "\n";
			clientOutputStream.writeBytes(replyText);
			System.out.println("Sent: " + replyText);

			clientOutputStream.close();
			clientInput.close();
			connectionSocket.close();
			serverSocket.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * Let's analyse a code for creating a server.
		 * 
		 * ServerSocket serverSocket = new ServerSocket(7654); - creates a simple server
		 * which listens on port 7654.
		 * 
		 * Socket connectionSocket = serverSocket.accept(); - when you run this code
		 * once, you will see that there is only one message on the screen, nothing past
		 * this line is executed. It is because this server is listening for
		 * connections, and only that. The method serverSocket.accept() is waiting for
		 * the connection. And if any connection appears, the ServerSocket will accept
		 * it, and this method will return a socket type which will be assigned to this
		 * object.
		 * 
		 * BufferedReader clientInput = new BufferedReader(new
		 * InputStreamReader(connectionSocket.getInputStream())); and DataOutputStream
		 * clientOutputStream = new
		 * DataOutputStream(connectionSocket.getOutputStream()); - here we are creating
		 * streams of data. Note that this is similar to reading from a text file and
		 * writing to a text file like in chapter10. We used Scanner and PrintWriter,
		 * here we are using other classes. And we connected those streams to the files,
		 * here we are connecting them to sockets.
		 * 
		 * Next we used methods readLine() and writeBytes() methods to read and write to
		 * a socket. Like with text files, you also write and read from files.
		 */

	}

}
