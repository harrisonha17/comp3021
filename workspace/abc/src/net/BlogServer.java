package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;
	public static void main(String [] args){
		try ( 
			    ServerSocket serverSocket = new ServerSocket(PORT);
			    Socket clientSocket = serverSocket.accept();
			    PrintWriter out =
			        new PrintWriter(clientSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(
			        new InputStreamReader(clientSocket.getInputStream()));
			){
				String inputLine;
				System.out.println("Some client connected");
				while ((inputLine = in.readLine()) != null){
					System.out.println("Receive data from client");
					System.out.println(inputLine);
				}
				in.close();
				clientSocket.close();
				serverSocket.close();
		}
		catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
