package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import commlib.Student;
import commlib.Update;

public class ServerMain {
	public static void main(String[] args){
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			ServerSocket sockServer = new ServerSocket(1286);
			Socket connection = sockServer.accept();
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
			while(true){
				Student received = (Student)in.readObject();
				if(received != null){
					System.out.println("Receiving Student");
					students.add(received);
					double average = 0;
					for(Student student : students){
						average += student.getScore();
					}
					
					average /= students.size();
					
					out.writeObject(new Update(students.size(), average));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
}
