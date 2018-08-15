package com.cooksys.assignment_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {

	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;

	String message;

	public ClientHandler(Socket socket, DataInputStream dis, DataOutputStream dos) {
		this.socket = socket;
		this.dis = dis;
		this.dos = dos;
	}

	public void run() {
		try {
			Thread.sleep(3000);
			message = dis.readUTF();
			dos.writeUTF("Message accepted: " + message);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
