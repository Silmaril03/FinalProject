package com.psu.SWENG500.Powerlifting.application.ui;

import com.psu.SWENG500.Powerlifting.models.Account;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.image.*;

public class WheelNav extends Pane{
	public WheelNav(){
		super();
	}
	
	public void loadGraphics(Account currentUser, Label usernameSetLabel, TextField firstNameTextField, TextField lastNameTextField, TextField emailTextField, Label genderLabel, final Pane settingsPane, final Pane articlesPane, final Pane measurementPane, final Pane navWheelPane, final Pane statisticsPane, final Pane workoutPane){
		Button setting = new Button();
		Button articles = new Button();
		Button workout = new Button();
		Button measurement = new Button();
		Button stats = new Button();
		double width = 200;
		double height = 100;
		
		Image settingImage = new Image(getClass().getClassLoader().getResourceAsStream("application/images/setting.png"));
		ImageView image = new ImageView(settingImage);
		image.setFitHeight(30);
		image.setFitWidth(30);
		
		setting.setGraphic(image);
		setting.setMinSize(width, height);
		setting.setMaxSize(width, height);
		setting.setLayoutX(300);
		setting.setLayoutY(100);
		setting.setText("Account Setting");
		setting.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	usernameSetLabel.setText(currentUser.getNickname());
        		firstNameTextField.setText(currentUser.getFirstName());
        		lastNameTextField.setText(currentUser.getLastName());
        		emailTextField.setText(currentUser.getEmailAddress());
        		genderLabel.setText(currentUser.getGender());
        		
            	settingsPane.setVisible(true);
                navWheelPane.setVisible(false);
            }
        });
		this.getChildren().add(setting);
		
		settingImage = new Image(getClass().getClassLoader().getResourceAsStream("application/images/articles.png"));
		image = new ImageView(settingImage);
		image.setFitHeight(30);
		image.setFitWidth(30);
		
		articles.setGraphic(image);
		articles.setMinSize(width, height);
		articles.setMaxSize(width, height);
		articles.setLayoutX(150);
		articles.setLayoutY(250);
		articles.setText("Articles");
		articles.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                articlesPane.setVisible(true);
                navWheelPane.setVisible(false);
            }
        });
		this.getChildren().add(articles);
		
		settingImage = new Image(getClass().getClassLoader().getResourceAsStream("application/images/workout.png"));
		image = new ImageView(settingImage);
		image.setFitHeight(30);
		image.setFitWidth(30);
		
		workout.setGraphic(image);
		workout.setMinSize(width, height);
		workout.setMaxSize(width, height);
		workout.setLayoutX(450);
		workout.setLayoutY(250);
		workout.setText("Workout Log");
		workout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                workoutPane.setVisible(true);
                navWheelPane.setVisible(false);
            }
        });
		this.getChildren().add(workout);
		
		settingImage = new Image(getClass().getClassLoader().getResourceAsStream("application/images/stats.png"));
		image = new ImageView(settingImage);
		image.setFitHeight(30);
		image.setFitWidth(30);
		
		stats.setGraphic(image);
		stats.setMinSize(width, height);
		stats.setMaxSize(width, height);
		stats.setLayoutX(150);
		stats.setLayoutY(400);
		stats.setText("Statistics");
		stats.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                statisticsPane.setVisible(true);
                navWheelPane.setVisible(false);
            }
        });
		this.getChildren().add(stats);
		
		settingImage = new Image(getClass().getClassLoader().getResourceAsStream("application/images/measurement.png"));
		image = new ImageView(settingImage);
		image.setFitHeight(30);
		image.setFitWidth(30);
		
		measurement.setGraphic(image);
		measurement.setMinSize(width, height);
		measurement.setMaxSize(width, height);
		measurement.setLayoutX(450);
		measurement.setLayoutY(400);
		measurement.setText("Measurement");
		measurement.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                measurementPane.setVisible(true);
                navWheelPane.setVisible(false);
            }
        });
		this.getChildren().add(measurement);
	}
	
}
