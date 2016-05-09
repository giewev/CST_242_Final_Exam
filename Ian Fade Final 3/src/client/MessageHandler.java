package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import commlib.Student;
import commlib.Update;
import javafx.scene.control.Label;

public class MessageHandler implements Runnable{
	private Socket sock;
	ClientMain receiver;
	
	public MessageHandler(Socket sock, ClientMain receiver){
		this.sock = sock;
		this.receiver = receiver;
	}
	
	public void sendStudent(Student student){
		try {
			ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
			out.writeObject(student);
			System.out.println("Sending student");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void run(){
		try {
			ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
			while(true){
				Update update = (Update)in.readObject();
				if(update != null){
					System.out.println("Receiving Update");
					this.receiver.setCount("Count: " + update.getCount());
					this.receiver.setAverage("Average: " + update.getAverage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
