package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import com.psu.SWENG500.Powerlifting.application.ui.RestrictiveTextField;
import com.psu.SWENG500.Powerlifting.dal.IWorkoutDAO;
import com.psu.SWENG500.Powerlifting.dal.WorkoutDaoFactory;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;
import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.AccountUI;
import com.psu.SWENG500.Powerlifting.models.ui.NewsArticle;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML private RestrictiveTextField usernameTextField;
	@FXML private PasswordField passwordTextField;
	@FXML private Button loginButton;
	@FXML private ScrollBar workoutScrollBar;
	@FXML private TableView<WorkoutSetUI> workoutTable;
	@FXML private RestrictiveTextField weightTextBox;
	@FXML private RestrictiveTextField repsTextBox;
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
	
	@FXML private Tab workoutTab;
	@FXML private Tab articlesTab;
	@FXML private Tab statisticsTab;
	@FXML private Tab measurementsTab;
	
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
	private ObservableList<WorkoutSetUI> setList = FXCollections.observableArrayList();
	
	private List<NewsArticle> articleList;
	private NewsArticleController articleController = new NewsArticleController();
	
	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		addExercise.getItems().addAll(exerciseList);
		exerciseComboBox.getItems().addAll(exerciseList);
		bodyCompositionComboBox.getItems().addAll(bodyCompositionList);
		heightInFeetComboBox.getItems().addAll(heightInFeetList);
		heightInInchesComboBox.getItems().addAll(heightInInchesList);
		workoutTable.setItems(setList);
		usernameTextField.setRestrict("[0-9 | a-z]");
		weightTextBox.setRestrict("-?((\\d*)|(\\d+\\.\\d*))");
		repsTextBox.setRestrict("[0-9]");
//		workoutTab.setDisable(true);
//		articlesTab.setDisable(true);
//		measurementsTab.setDisable(true);
//		statisticsTab.setDisable(true);
	}
	
	@FXML
	public void addSetButtonAction(ActionEvent event){
		String exer = addExercise.getValue();
		int rep = Integer.parseInt(repsTextBox.getText());
		double weight = Double.parseDouble(weightTextBox.getText());
		
		WorkoutSet workoutSet = new WorkoutSet();
		workoutSet.setExercise(exer);
		workoutSet.setRepCount(rep);
		workoutSet.setWeightLifted(weight);
		int set = trainingLogController.getSet();
		workoutSet.setSetNumber(set);
		trainingLogController.addWorkoutSet(workoutSet);
		
		WorkoutSetUI workoutUI = new WorkoutSetUI(set++, weight, rep, exer);
		setList.add(workoutUI);
	}
	
	@FXML
	public void saveWorkoutButtonAction(ActionEvent event){
		//IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("IplDb");
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		trainingLogController.getWorkout().setWorkoutDate(java.sql.Date.valueOf(workoutDate.getValue()));//workoutDate.getValue());
		try {
			wDao.CreateWorkout(trainingLogController.getWorkout(), 38);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loginAction(ActionEvent event){
		AccountUI accountUI = new AccountUI();
		accountUI.setUsername(usernameTextField.getText());
		accountUI.setPassword(passwordTextField.getText());
		
		workoutTab.setDisable(false);
		articlesTab.setDisable(false);
		measurementsTab.setDisable(false);
		statisticsTab.setDisable(false);
	}
	
	@FXML
	public void registerAction(ActionEvent event){
		AccountUI accountUI = new AccountUI();
		accountUI.setUsername(usernameTextField.getText());
		accountUI.setPassword(passwordTextField.getText());
		
		workoutTab.setDisable(false);
		articlesTab.setDisable(false);
		measurementsTab.setDisable(false);
		statisticsTab.setDisable(false);
	}
	
	@FXML
	public void readArticlesTabAction(ActionEvent event){
		System.out.println("Size of article list " + articleList.size());
		NewsArticle articleTest1 = articleList.get(0);
		article1.setText(articleTest1.getArticleTitle() + "\n" + articleTest1.getArticleDate() + "\n" + 
				articleTest1.getArticleShortDescription() + "\n" + articleTest1.getSiteOrigin());
		
		NewsArticle articleTest2 = articleList.get(1);
		article1.setText(articleTest2.getArticleTitle() + "\n" + articleTest2.getArticleDate() + "\n" + 
				articleTest2.getArticleShortDescription() + "\n" + articleTest2.getSiteOrigin());
		
		NewsArticle articleTest3 = articleList.get(2);
		article1.setText(articleTest3.getArticleTitle() + "\n" + articleTest3.getArticleDate() + "\n" + 
				articleTest3.getArticleShortDescription() + "\n" + articleTest3.getSiteOrigin());

        final WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(articleTest1.getSiteOrigin());
	}
	
	@FXML
	public void showFirstArticle(ActionEvent event){
		NewsArticle articleTest1 = articleList.get(0);
		article1.setText(articleTest1.getArticleTitle() + "\n" + articleTest1.getArticleDate() + "\n" + 
				articleTest1.getArticleShortDescription() + "\n" + articleTest1.getSiteOrigin());
		final WebEngine webEngine = webView.getEngine();
        webEngine.load(articleTest1.getSiteOrigin());
	}
	
	@FXML
	public void showSecondArticle(ActionEvent event){
		NewsArticle articleTest2 = articleList.get(1);
		article2.setText(articleTest2.getArticleTitle() + "\n" + articleTest2.getArticleDate() + "\n" + 
				articleTest2.getArticleShortDescription() + "\n" + articleTest2.getSiteOrigin());
		final WebEngine webEngine = webView.getEngine();
        webEngine.load(articleTest2.getSiteOrigin());
	}
	
	@FXML
	public void showThirdArticle(ActionEvent event){
		NewsArticle articleTest3 = articleList.get(2);
		article3.setText(articleTest3.getArticleTitle() + "\n" + articleTest3.getArticleDate() + "\n" + 
				articleTest3.getArticleShortDescription() + "\n" + articleTest3.getSiteOrigin());
		final WebEngine webEngine = webView.getEngine();
        webEngine.load(articleTest3.getSiteOrigin());
	}
}