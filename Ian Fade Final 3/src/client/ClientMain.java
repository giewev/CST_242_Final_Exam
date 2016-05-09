package client;

import java.net.Socket;

import commlib.Student;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientMain extends Application implements EventHandler<ActionEvent>{
	MessageHandler handler;
	TextField nameField;
	TextField idField;
	TextField scoreField;
	
	Label countLabel;
	Label averageLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox layout = new VBox();
		Scene scene = new Scene(layout);
		
		Label nameLabel = new Label("Name");
		nameField = new TextField();
		Label idLabel = new Label("ID");
		idField = new TextField();
		Label scoreLabel = new Label("Score");
		scoreField = new TextField();
		Button sendButton = new Button("Send");
		
		Label count = new Label("Count: 0");
		Label average = new Label("Average: NA");
		this.countLabel = count;
		this.averageLabel = average;

		layout.getChildren().add(nameLabel);
		layout.getChildren().add(nameField);
		layout.getChildren().add(idLabel);
		layout.getChildren().add(idField);
		layout.getChildren().add(scoreLabel);
		layout.getChildren().add(scoreField);
		layout.getChildren().add(sendButton);
		layout.getChildren().add(count);
		layout.getChildren().add(average);
		
		handler = new MessageHandler(new Socket("127.0.0.1", 1286), this);
		
		sendButton.setOnAction(this);
		
		Thread handlerThread = new Thread(handler);
		handlerThread.start();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setCount(String newCount){
		this.countLabel.setText(newCount);
	}
	
	public void setAverage(String newAverage){
		this.averageLabel.setText(newAverage);
	}
	
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		double score = Double.parseDouble(this.scoreField.getText());
		long id = Long.parseLong(this.idField.getText());
		
		Student student = new Student(this.nameField.getText(), id, score);
		this.handler.sendStudent(student);
	}
}
