package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML private TextField usernameTextField;
	@FXML private TextField passwordTextField;
	@FXML private Button loginButton;
	@FXML private ScrollBar workoutScrollBar;
	@FXML private TableView<WorkoutSet> workoutTable;
	@FXML private TextField weightTextBox;
	@FXML private TextField repsTextBox;
	@FXML private ComboBox<String> addExercise;
	@FXML private Button removeExercise;
	@FXML private Button addSet;
	@FXML private Button removeSet;
	@FXML private Button logWorkout;
	@FXML private DatePicker workoutDate;
	@FXML LineChart<String, Number> exerciseLineChart;
	@FXML LineChart<String, Number> bodyCompositionLineChart;
	@FXML private ComboBox<String> exerciseComboBox;
	@FXML private ComboBox<String> bodyCompositionComboBox;
	@FXML private TextField searchTextBox;
	@FXML private Button searchButton;
	@FXML private ComboBox<String> searchHistory;
	@FXML private WebView webView;
	@FXML private ScrollBar articleScrollBar;
	@FXML private Label article1;
	@FXML private Label article2;
	@FXML private Label article3;
	@FXML private DatePicker measurementsDate;
	@FXML private ComboBox<String> heightInFeetComboBox;
	@FXML private ComboBox<String> heightInInchesComboBox;
	@FXML private TextField weightTextField;
	@FXML private TextField neckTextField;
	@FXML private TextField waistTextField;
	@FXML private Button saveMeasurementsButton;
	
	ObservableList<String> exerciseList = FXCollections.observableArrayList("Back Extension", 
				"Bench Press, Barbell", "Bench Press, Close Grip", "Bench Press, Dumbbell",
				"Biceps Curl, Barbell", "Biceps Curl, Dumbbell", "Bulgarian Split Squat", "Chin-up",
				"Dead Bench", "Deadlift, Barbell", "Deadlift, Romanian", "Deadlift, Stiff-legged", 
				"Deadlift, Trap Bar", "Deadlift, Deficit", 
				"Dip, Bench", "Dip, Parallel Bar", "Dip, Ring",
				"Face Pull, Cable", "Glute-Ham Raise", "Good Morning, Barbell",
				"Hammer Curl", "Hip Thrust, Barbell", "Lat Pull", "Lunge", "Pin Squat", "Power Clean",
				"Press, Barbell", "Press, Dumbbell", "Pull-up", "Rack Pull", "Reverse Hyper", 
				"Row, Barbell", "Row, Cable",
				"Row, Dumbbell", "Row, T-Bar", 
				"Skull Crusher", "Spoto Press", "Squat, Barbell", "Triceps Extension, Cable");
	ObservableList<String> bodyCompositionList = FXCollections.observableArrayList("Wilks Score", "Body Mass Index (BMI)", 
			"Body Fat Percentage", "Lean Body Mass", "Total Volume");
	ObservableList<String> heightInFeetList = FXCollections.observableArrayList("3 feet","4 feet", "5 feet", 
			"6 feet", "7 feet");
	ObservableList<String> heightInInchesList = FXCollections.observableArrayList("0 inches", "1 inch", 
			"2 inches", "3 inches", "4 inches", "5 inches", "6 inches", "7 inches", "8 inches", "9 inches",
			"10 inches", "11 inches");
		
	private TrainingLogController trainingLogController = new TrainingLogController();
	private ObservableList<WorkoutSet> setList = FXCollections.observableArrayList();
	
	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		addExercise.getItems().addAll(exerciseList);
		exerciseComboBox.getItems().addAll(exerciseList);
		bodyCompositionComboBox.getItems().addAll(bodyCompositionList);
		heightInFeetComboBox.getItems().addAll(heightInFeetList);
		heightInInchesComboBox.getItems().addAll(heightInInchesList);
		workoutTable.setItems(setList);
		
	}
	
	@FXML
	public void addSetButtonAction(ActionEvent event){
		
		
		WorkoutSet workoutSet = new WorkoutSet();
		workoutSet.setExercise(addExercise.getValue());
		workoutSet.setRepCount(Integer.parseInt(repsTextBox.getText()));
		workoutSet.setWeightLifted(Double.parseDouble(weightTextBox.getText()));
		int set = trainingLogController.getSet();
		workoutSet.setSetNumber(set++);
		trainingLogController.addWorkoutSet(workoutSet);
		setList.add(workoutSet);
	}
	
	
	
	
}
