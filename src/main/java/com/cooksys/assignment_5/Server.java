package com.cooksys.assignment_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		try (ServerSocket ss = new ServerSocket(8081);) {
			System.out.println("Server Starting...");
			while (true) {

				Socket socket = ss.accept();
				
				DataInputStream reader = new DataInputStream(socket.getInputStream());
				DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
				
				System.out.println("A Client Connected.");

				ClientHandler client = new ClientHandler(socket, reader, writer);
				Thread t = new Thread(client);
				t.start();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
