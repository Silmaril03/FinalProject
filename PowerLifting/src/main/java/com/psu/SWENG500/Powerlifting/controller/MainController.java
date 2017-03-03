package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class MainController implements Initializable {
	
	@FXML
	public Button addExerciseButton = new Button();
	
	@FXML
	public Button deleteExerciseButton = new Button();
	
	@FXML
	public Button logWorkoutButton = new Button();
	
	@FXML
	public Button addSetButton = new Button();
	
	@FXML
	public ComboBox<String> exerciseComboBox = new ComboBox<String>();
	
	@FXML
	public ListView<String> listView = new ListView<String>();
	
	@FXML
	public TextField repsTextField = new TextField();
	
	@FXML
	public TextField weightTextField = new TextField();
	
	public ObservableList<String> exerciseList = FXCollections.observableArrayList("Squat", "Bench Press", "Deadlift","Press", "Barbell Row");
	
//	@Override
	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		exerciseComboBox.setItems(exerciseList);
		exerciseComboBox.setValue("Squat");
		listView.setSelectionModel(null);
			
	}
	
	public void addExerciseButtonPressed (ActionEvent event) {
		listView.getItems().add(exerciseComboBox.getValue());
	}
	
	public void listViewClicked (ActionEvent event) {
		
	}
	
	public void deleteExerciseButtonPressed (ActionEvent event) {
		listView.getItems().removeAll(exerciseList);
	}
	
	public void logWorkoutButtonPressed (ActionEvent event) {
		System.exit(0);
	}
	
	public void addSetButtonPressed (ActionEvent event) {
		if (repsTextField.getText() != null && weightTextField.getText() != null){
			StringBuilder line = new StringBuilder();
			line.append(repsTextField.getText()).append(" x ").append(weightTextField.getText());
			listView.getItems().add(line.toString());
		}
		}
	}
	
	
	

