package chapter19;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Sub2a {
	/*
	 * How to run this program is explained at the bottom. First read the full code
	 * first.
	 */

	public static void main(String[] args) {
		try {
			String hostname = "localhost";
			int port = 7654;

			System.out.println("Connecting to server on port " + port);

			Socket connectionSock = new Socket(hostname, port);

			BufferedReader serverInput = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
			DataOutputStream serverOutput = new DataOutputStream(connectionSock.getOutputStream());

			System.out.println("Connection made, sending name.");
			serverOutput.writeBytes("Dusty Rhodes\n");
			System.out.println("Waiting for reply.");
			String serverData = serverInput.readLine();
			System.out.println("Received: " + serverData);

			serverOutput.close();
			serverInput.close();
			connectionSock.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * Let's analyse a code for creating a client that will connect to the server.
		 * 
		 * Socket connectionSock = new Socket(hostname, port); - tries to connect to a
		 * server with given hostname and port. If the hostname is "localhost" it points
		 * to this machine. If the server is on the Internet, in hostname, give name of
		 * a host (website with server). In our previous program, we invoked method
		 * accept(). This means that these two programs (server and client) are
		 * connected and connectionSock now points to the other device. Same as in our
		 * previous program, its object of type Socket, points to this device.
		 * 
		 * Next lines are to assign streams like with text files but here with sockets.
		 */
	}
	/*
	 * How to run this program.
	 * 
	 * Firstly run Sub2.java. You will see that it is waiting for a connection on
	 * port 7654.
	 * 
	 * Secondly run Sub2a.java. You will see that next lines of code appeared.
	 * Connection made and what have been sent.
	 * 
	 * Thirdly. Depending on your IDE, in the console window, on your right side you
	 * have few buttons that belong to the console view. One of them is
	 * "display selected console". When you run 2 program, in result you have 2
	 * console with different messages printed. With this button you can switch
	 * between console of those two programs and see that you needed to programs to
	 * run this code. One to be a server and another to be a client. And those two
	 * programs communicated with each other.
	 */
}