package client.clientcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientController {

	private Socket aSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private BufferedReader stdIn;

	public ClientController(String serverName, int portNumber) {

		try {
			aSocket = new Socket(serverName, portNumber);
			// keyboard input stream
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			// Socket input stream
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * communicate with the server
	 * 
	 * @param line input
	 * @return output from the server
	 */
	public String communicate(String line) {

		String response = "";

		try {
			socketOut.println(line);

			response = socketIn.readLine(); // read response from the socket
			System.out.println("Response is: " + response);

		} catch (IOException e) {
			e.getStackTrace();
		}
		return response;
	}

	/**
	 * close the socket
	 */
	public void close() {
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
			System.out.println("system connection ended");
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}