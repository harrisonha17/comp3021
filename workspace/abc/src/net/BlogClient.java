package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import abc.Post;
public class BlogClient {
	public static final String IP ="127.0.0.1";
	public static final int PORT = 3021;
	public static void main(String[] args){
		try (
			    Socket echoSocket = new Socket(IP, PORT);
			    PrintWriter out =
			        new PrintWriter(echoSocket.getOutputStream(), true);
			    BufferedReader in =
			        new BufferedReader(
			            new InputStreamReader(echoSocket.getInputStream()));
			){
			String inputLine, outputLine = null;
			Post post = new Post(new Date(), "Client: ");
			outputLine = post.toString();
			out.println(outputLine);
			while((inputLine = in.readLine())!=null){
				System.out.println("Server: " + inputLine);
			}
			in.close();
			out.close();
			echoSocket.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
