package com.cooksys.assignment_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<Socket> socketList = new ArrayList<Socket>();

		for (int i = 0; i < 10; i++) {
			try {
				socketList.add(new Socket("localhost", 8081));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			try (DataInputStream dis = new DataInputStream(socketList.get(i).getInputStream());
					DataOutputStream dos = new DataOutputStream(socketList.get(i).getOutputStream());) {
				String output = "Apples & Oranges";
				dos.writeUTF(output);
				System.out.println(dis.readUTF());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
