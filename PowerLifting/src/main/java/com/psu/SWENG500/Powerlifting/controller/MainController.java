package com.psu.SWENG500.Powerlifting.controller;

import java.net.URL;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import com.psu.SWENG500.Powerlifting.application.ui.RestrictiveTextField;
import com.psu.SWENG500.Powerlifting.application.ui.WheelNav;
import com.psu.SWENG500.Powerlifting.dal.AccountDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.IAccountDAO;
import com.psu.SWENG500.Powerlifting.dal.IMeasurementsDAO;
import com.psu.SWENG500.Powerlifting.dal.IWorkoutDAO;
import com.psu.SWENG500.Powerlifting.dal.MeasurementsDaoFactory;
import com.psu.SWENG500.Powerlifting.dal.WorkoutDaoFactory;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.ImperialMeasurement;
import com.psu.SWENG500.Powerlifting.models.Measurements;
import com.psu.SWENG500.Powerlifting.models.Workout;
import com.psu.SWENG500.Powerlifting.models.WorkoutSet;
import com.psu.SWENG500.Powerlifting.models.ui.WorkoutSetUI;
import com.psu.SWENG500.Powerlifting.models.Account;
import com.psu.SWENG500.Powerlifting.models.ConfigReader;
import com.psu.SWENG500.Powerlifting.models.Exercise;
import com.psu.SWENG500.Powerlifting.models.NewsArticleModel;
import com.psu.SWENG500.Powerlifting.models.TrainingLogModel;
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
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainController implements Initializable {
	@FXML
	private RestrictiveTextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Button loginButton;
	@FXML
	private ScrollBar workoutScrollBar;
	@FXML
	private TableView<WorkoutSetUI> workoutTable;
	@FXML
	private RestrictiveTextField weightTextBox;
	@FXML
	private RestrictiveTextField repsTextBox;
	@FXML
	private ComboBox<String> addExercise;
	@FXML
	private Button removeExercise;
	@FXML
	private Button addSet;
	@FXML
	private Button removeSet;
	@FXML
	private Button logWorkout;
	@FXML
	private DatePicker workoutDate;
	@FXML
	LineChart<String, Number> exerciseLineChart;
	@FXML
	LineChart<String, Number> bodyCompositionLineChart;
	@FXML
	private ComboBox<String> exerciseComboBox;
	@FXML
	private ComboBox<String> bodyCompositionComboBox;
	@FXML
	private TextField searchTextBox;
	@FXML
	private Button searchButton;
	@FXML
	private ComboBox<String> searchHistory;
	@FXML
	private WebView webView;
	@FXML
	private ScrollBar articleScrollBar;
	@FXML
	private Button article1;
	@FXML
	private Button article2;
	@FXML
	private Button article3;
	@FXML
	private Button refreshButton;
	@FXML
	private DatePicker measurementsDate;
	@FXML
	private ComboBox<String> heightInFeetComboBox;
	@FXML
	private ComboBox<String> heightInInchesComboBox;
	@FXML
	private TextField weightTextField;
	@FXML
	private TextField neckTextField;
	@FXML
	private TextField waistTextField;
	@FXML
	private Button saveMeasurementsButton;
	@FXML
	private Label loginErrorLabel;
	@FXML
	private Label workoutLogErrorLabel;
	@FXML
	private Label articleErrorLabel;
	@FXML
	private Label weightErrorLabel;
	@FXML
	private Label neckErrorLabel;
	@FXML
	private Label waistErrorLabel;
	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private TextField emailTextField;
	@FXML
	private Label usernameSetLabel;
	@FXML
	private Label saveUserLabel;
	@FXML
	private TextField passwordSetTextField;
	@FXML
	private Label genderLabel;

	@FXML
	private TextField rFirstNameTextField;
	@FXML
	private TextField rLastNameTextField;
	@FXML
	private TextField rEmailTextField;
	@FXML
	private RestrictiveTextField rUsernameSetTextField;
	@FXML
	private TextField rPasswordSetTextField;
	@FXML
	private ComboBox<String> rGenderComboBox;

	@FXML
	private Label lblCurrentUser;
	@FXML
	private Pane mainPane;
	@FXML
	private Pane workoutPane;
	@FXML
	private Pane statisticsPane;
	@FXML
	private Pane measurementPane;
	@FXML
	private Pane articlesPane;
	@FXML
	private WheelNav navWheelPane;
	@FXML
	private Pane settingsPane;
	@FXML
	private Pane registerPane;

	private Account currentUser;

	private boolean loggedIn = false;

	ObservableList<String> exerciseList = FXCollections.observableArrayList(
			"Back Extension", "Bench Press, Barbell",
			"Bench Press, Close Grip", "Bench Press, Dumbbell",
			"Biceps Curl, Barbell", "Biceps Curl, Dumbbell",
			"Bulgarian Split Squat", "Chin-up", "Dead Bench",
			"Deadlift, Barbell", "Deadlift, Romanian",
			"Deadlift, Stiff-legged", "Deadlift, Trap Bar",
			"Deadlift, Deficit", "Dip, Bench", "Dip, Parallel Bar",
			"Dip, Ring", "Face Pull, Cable", "Glute-Ham Raise",
			"Good Morning, Barbell", "Hammer Curl", "Hip Thrust, Barbell",
			"Lat Pull", "Lunge", "Pin Squat", "Power Clean", "Press, Barbell",
			"Press, Dumbbell", "Pull-up", "Rack Pull", "Reverse Hyper",
			"Row, Barbell", "Row, Cable", "Row, Dumbbell", "Row, T-Bar",
			"Skull Crusher", "Spoto Press", "Squat, Barbell",
			"Triceps Extension, Cable");
	ObservableList<String> bodyCompositionList = FXCollections
			.observableArrayList("Wilks Score", "Body Mass Index (BMI)",
					"Body Fat Percentage", "Lean Body Mass", "Total Volume");
	ObservableList<String> heightInFeetList = FXCollections
			.observableArrayList("3 feet", "4 feet", "5 feet", "6 feet",
					"7 feet");
	ObservableList<String> heightInInchesList = FXCollections
			.observableArrayList("0 inches", "1 inch", "2 inches", "3 inches",
					"4 inches", "5 inches", "6 inches", "7 inches", "8 inches",
					"9 inches", "10 inches", "11 inches");
	ObservableList<String> genderList = FXCollections.observableArrayList(
			"Male", "Female");

	private TrainingLogController trainingLogController = new TrainingLogController();
	private TrainingLogModel trainingLog = new TrainingLogModel();
	private List<Measurements> userMeasurements = new ArrayList<Measurements>();
	private ObservableList<WorkoutSetUI> setList = FXCollections
			.observableArrayList();

	private List<NewsArticle> articleList;
	private NewsArticleController articleController = new NewsArticleController();
	private List<String> searchHistoryList = new ArrayList<String>();

	@FXML
	public void initialize(URL arg0, ResourceBundle arg1) {
		addExercise.getItems().addAll(exerciseList);
		exerciseComboBox.getItems().addAll(exerciseList);
		bodyCompositionComboBox.getItems().addAll(bodyCompositionList);
		heightInFeetComboBox.getItems().addAll(heightInFeetList);
		heightInInchesComboBox.getItems().addAll(heightInInchesList);
		workoutTable.setItems(setList);
		rGenderComboBox.getItems().addAll(genderList);
		usernameTextField.setRestrict("[0-9 | a-z | A-Z]");
		weightTextBox.setRestrict("-?((\\d*)|(\\d+\\.\\d*))");
		repsTextBox.setRestrict("[0-9]");

		settingsPane.setVisible(false);
		navWheelPane.setVisible(false);
		articlesPane.setVisible(false);
		statisticsPane.setVisible(false);
		measurementPane.setVisible(false);
		workoutPane.setVisible(false);
		registerPane.setVisible(false);

		try {
			loadArticleTabProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addSetButtonAction(ActionEvent event) {
		String exer = addExercise.getValue();
		try {
			Integer rep = Integer.parseInt(repsTextBox.getText());
			Double weight = Double.parseDouble(weightTextBox.getText());
			if (exer != null || !exer.isEmpty() || rep != null
					|| weight != null) {
				WorkoutSet workoutSet = new WorkoutSet();
				workoutSet.setExercise(exer);
				workoutSet.setRepCount(rep);
				workoutSet.setWeightLifted(weight);
				int set = trainingLogController.getSet();
				workoutSet.setSetNumber(set);
				trainingLogController.addWorkoutSet(workoutSet);

				WorkoutSetUI workoutUI = new WorkoutSetUI(set++, weight, rep,
						exer);
				setList.add(workoutUI);
			} else if (exer.isEmpty()) {
				// TODO
			}
		} catch (NumberFormatException e) {
			// log exception
		}
	}

	@FXML
	public void saveWorkoutButtonAction(ActionEvent event) {
		// IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("IplDb");
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		trainingLogController.getWorkout().setWorkoutDate(
				java.sql.Date.valueOf(workoutDate.getValue()));// workoutDate.getValue());
		try {
			wDao.CreateWorkout(trainingLogController.getWorkout(),
					this.currentUser.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void loginAction(ActionEvent event) {
		IAccountDAO aDao = AccountDaoFactory.GetAccountDAO("TestDb");
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		IMeasurementsDAO mDao = MeasurementsDaoFactory.GetMeasurementDAO("TestDb");
		try {
			this.currentUser = aDao.GetAccount(usernameTextField.getText(),
					passwordTextField.getText());
			if (this.currentUser != null) {
				usernameTextField.setText("");
				passwordTextField.setText("");
				lblCurrentUser.setText("Current User: "
						+ this.currentUser.getNickname());
				trainingLog = new TrainingLogModel(wDao.GetWorkouts(this.currentUser.getUserId()));
				this.userMeasurements = mDao.GetMeasurements(this.currentUser.getUserId());
				loggedIn = true;

				navWheelPane.loadGraphics(currentUser, usernameSetLabel,
						firstNameTextField, lastNameTextField, emailTextField,
						genderLabel, settingsPane, articlesPane,
						measurementPane, navWheelPane, statisticsPane,
						workoutPane);
				navWheelPane.setVisible(true);
				mainPane.setVisible(false);
			} else
				lblCurrentUser
						.setText("Current User: Invalid Username and/or Password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void registerAction(ActionEvent event) {
		mainPane.setVisible(false);
		registerPane.setVisible(true);
	}

	@FXML
	public void showFirstArticle(ActionEvent event) {
		webView.getEngine().load(articleList.get(0).getSiteOrigin());
	}

	@FXML
	public void showSecondArticle(ActionEvent event) {
		webView.getEngine().load(articleList.get(1).getSiteOrigin());
	}

	@FXML
	public void showThirdArticle(ActionEvent event) {
		webView.getEngine().load(articleList.get(2).getSiteOrigin());
	}

	private void loadArticleTabProperties() throws Exception {
		articleList = articleController.retrieveNewsArticleList();
		if (articleList == null || articleList.isEmpty()) {
			throw new Exception();
		}
		setFirstArticleButton(articleList.get(0));
		setSecondArticleButton(articleList.get(1));
		setThirdArticleButton(articleList.get(2));
	}

	private void setFirstArticleButton(NewsArticle newsArticle) {
		if (article1.isDisable()) {
			article1.setDisable(false);
		}
		article1.wrapTextProperty().setValue(true);
		article1.setAlignment(Pos.BASELINE_CENTER);
		article1.setText(newsArticle.getArticleTitle());
		webView.getEngine().load(newsArticle.getSiteOrigin());
	}

	private void setSecondArticleButton(NewsArticle newsArticle) {
		if (article2.isDisable()) {
			article2.setDisable(false);
		}
		article2.wrapTextProperty().setValue(true);
		article2.setAlignment(Pos.BASELINE_CENTER);
		article2.setText(newsArticle.getArticleTitle());
	}

	private void setThirdArticleButton(NewsArticle newsArticle) {
		if (article3.isDisable()) {
			article3.setDisable(false);
		}
		article3.wrapTextProperty().setValue(true);
		article3.setAlignment(Pos.BASELINE_CENTER);
		article3.setText(newsArticle.getArticleTitle());
	}

	private void disableFirstArticleButton() {
		article1.setText("");
		article1.setDisable(true);
	}

	private void disableSecondArticleButton() {
		article2.setText("");
		article2.setDisable(true);
	}

	private void disableThirdArticleButton() {
		article3.setText("");
		article3.setDisable(true);
	}

	@FXML
	public void searchArticlesAction(ActionEvent event) {
		if (!searchTextBox.getText().equals("")) {
			searchHistoryList.add(searchTextBox.getText());
			searchHistory.setItems(FXCollections
					.observableArrayList(searchHistoryList));
			boolean successfulSearch = searchArticles(searchTextBox.getText());

			if (!successfulSearch) {
				// Display 'no searches found' message. need label
			}
		}
	}

	@FXML
	public void showSearchHistory(ActionEvent event) {
		boolean successfulSearch = searchArticles(searchHistory.getValue());

		if (!successfulSearch) {
			// Display 'no searches found' message. need label
		}
	}

	private boolean searchArticles(String searchString) {
		List<NewsArticle> searchArticleList = articleController
				.searchArticles(searchString);
		if (searchArticleList.size() != 0) {
			setFirstArticleButton(searchArticleList.get(0));
			if (searchArticleList.size() >= 2) {
				setSecondArticleButton(searchArticleList.get(1));
				if (searchArticleList.size() >= 3) {
					setThirdArticleButton(searchArticleList.get(2));
				} else {
					disableThirdArticleButton();
				}
			} else {
				disableSecondArticleButton();
				disableThirdArticleButton();
			}
		} else {
			return false;
		}
		return true;
	}

	@FXML
	public void refreshNewsArticles(ActionEvent event) throws Exception {
		loadArticleTabProperties();
	}

	@FXML
	public void saveMeasurementsButtonAction(ActionEvent event) {
		IMeasurementsDAO mDao = MeasurementsDaoFactory
				.GetMeasurementDAO("TestDb");
		double feet = Double.parseDouble(heightInFeetComboBox.getValue().split(
				"[ ]")[0]);
		double inches = Double.parseDouble(heightInInchesComboBox.getValue()
				.split("[ ]")[0]);
		double totalHeight = (feet * 12) + inches;

		ImperialMeasurement m = new ImperialMeasurement(totalHeight,
				Double.parseDouble(weightTextField.getText()),
				Double.parseDouble(waistTextField.getText()), 0, 0, 0);
		m.setUserId(this.currentUser.getUserId());
		m.setMeasurementDate(java.sql.Date.valueOf(measurementsDate.getValue()));
		m.setNeck(0.0);
		try {
			mDao.CreateMeasurement(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void saveUserButtonAction(ActionEvent event) {
		if (validateString(rUsernameSetTextField.getText())
				&& validateString(rPasswordSetTextField.getText())
				&& validateString(rFirstNameTextField.getText())
				&& validateString(rLastNameTextField.getText())
				&& validateString(rEmailTextField.getText())
				&& validateGender(rGenderComboBox.getValue())) {
			
			IAccountDAO aDao = AccountDaoFactory.GetAccountDAO("TestDb");
			this.currentUser = new Account();
			this.currentUser.setNickname(rUsernameSetTextField.getText());
			this.currentUser.setPassword(rPasswordSetTextField.getText());
			this.currentUser.setFirstName(rFirstNameTextField.getText());
			this.currentUser.setLastName(rLastNameTextField.getText());
			this.currentUser.setEmailAddress(rEmailTextField.getText());
			this.currentUser.setGender(rGenderComboBox.getValue());
			try {
				this.currentUser = aDao.CreateAccount(this.currentUser);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			navWheelPane.loadGraphics(currentUser, usernameSetLabel,
					firstNameTextField, lastNameTextField, emailTextField,
					genderLabel, settingsPane, articlesPane, measurementPane,
					navWheelPane, statisticsPane, workoutPane);
			registerPane.setVisible(false);
			navWheelPane.setVisible(true);
			
			lblCurrentUser.setText("Current User: "
					+ this.currentUser.getNickname());

			loggedIn = true;
		} else {
			saveUserLabel.setText("Not all fields are filled out");
		}
	}

	@FXML
	public void saveSettingsButtonAction(ActionEvent event) {
		this.currentUser.setPassword(passwordSetTextField.getText());
		this.currentUser.setFirstName(firstNameTextField.getText());
		this.currentUser.setLastName(lastNameTextField.getText());
		this.currentUser.setEmailAddress(emailTextField.getText());
		
		settingsPane.setVisible(false);
		navWheelPane.setVisible(true);
	}

	@FXML
	public void workoutDateChanged(ActionEvent event) {
		IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		try {
			Workout selectedWorkout = trainingLog
					.GetWorkout(new SimpleDateFormat("yyyy-MM-dd").parse(String
							.valueOf(workoutDate.getValue())));
			trainingLogController.setWorkout(selectedWorkout);
			setList.clear();
			if (selectedWorkout != null) {
				for (WorkoutSet ws : trainingLogController.getWorkout()
						.GetWorkoutSets()) {
					WorkoutSetUI workoutUI = new WorkoutSetUI(
							ws.getSetNumber(), ws.getWeightLifted(),
							ws.getRepCount(), ws.getExerciseName());
					setList.add(workoutUI);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// IWorkoutDAO wDao = WorkoutDaoFactory.GetWorkoutDAO("TestDb");
		// try
		// {
		// Workout selectedWorkout =
		// wDao.GetWorkoutByDate(java.sql.Date.valueOf(workoutDate.getValue()));
		// trainingLogController.setWorkout(selectedWorkout);
		// setList.clear();
		// for (WorkoutSet ws :
		// trainingLogController.getWorkout().GetWorkoutSets())
		// {
		// WorkoutSetUI workoutUI = new WorkoutSetUI(ws.getSetNumber(),
		// ws.getWeightLifted(), ws.getRepCount(), ws.getExerciseName());
		// setList.add(workoutUI);
		// }
		// } catch (SQLException e)
		// {
		// e.printStackTrace();
		// }
	}

	@FXML
	public void exerciseChanged(ActionEvent event) {
		exerciseLineChart.getData().clear();
		XYChart.Series series = new XYChart.Series();
		series.setName(exerciseComboBox.getValue());
		List<Workout> tempWorkouts = this.trainingLog
				.GetWorkoutsByExercise(exerciseComboBox.getValue());
		for (Workout w : tempWorkouts) {
			double weightLifted = w.getMaxVolumeByExercise(exerciseComboBox.getValue());
			String dateString = new SimpleDateFormat("MM/dd/yyyy").format(w.getWorkoutDate());
			series.getData().add(new XYChart.Data(dateString, weightLifted));
		}
		exerciseLineChart.getData().add(series);
	}
	
	@FXML
	public void bodyCompositionChanged(ActionEvent event) {
		CalculatorController cc = new CalculatorController();
		bodyCompositionLineChart.getData().clear();
		XYChart.Series series = new XYChart.Series();
		int selectedStatistic = bodyCompositionComboBox.getSelectionModel().getSelectedIndex();
		switch (selectedStatistic) {
			case 0:
				break;
			case 1:
				for (Measurements m : this.userMeasurements) {
					double bmi = cc.calculateBodyMassIndex(m);
					String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m.getMeasurementDate());
					series.getData().add(new XYChart.Data(dateString, bmi));
				}
				break;
			case 2:
				for (Measurements m : this.userMeasurements) {
					boolean tempIsMale = this.currentUser.getGender() == "Male" ? true : false;
					double bfp = cc.calculateBodyFatPercentage(m, tempIsMale);
					String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m.getMeasurementDate());
					series.getData().add(new XYChart.Data(dateString, bfp));
				}
				break;
			case 3:
				for (Measurements m : this.userMeasurements) {
					boolean tempIsMale = this.currentUser.getGender() == "Male" ? true : false;
					double lbm = cc.calculateLeanBodyMass(m, tempIsMale);
					String dateString = new SimpleDateFormat("MM/dd/yyyy").format(m.getMeasurementDate());
					series.getData().add(new XYChart.Data(dateString, lbm));
				}
				break;
			case 4:
				List<Workout> tempWorkouts = this.trainingLog.GetWorkouts();
				for (Workout w : tempWorkouts) {
					double weightLifted = w.getTotalVolume();
					String dateString = new SimpleDateFormat("MM/dd/yyyy").format(w.getWorkoutDate());
					series.getData().add(new XYChart.Data(dateString, weightLifted));
				}
				break;
		}
		series.setName(bodyCompositionComboBox.getValue());
		bodyCompositionLineChart.getData().add(series);
	}
	
	@FXML
	public void rightClick(MouseEvent event) {
		if (!loggedIn) {
			return;
		}
		if (((MouseEvent) event).getButton().equals(MouseButton.SECONDARY)) {
			navWheelPane.setVisible(true);
			articlesPane.setVisible(false);
			measurementPane.setVisible(false);
			statisticsPane.setVisible(false);
			workoutPane.setVisible(false);
			settingsPane.setVisible(false);
		}
	}

	private boolean validateString(String entry) {
		if (entry != null) {
			if (!entry.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private boolean validateGender(String gender) {
		if (gender != null) {
			if (!gender.isEmpty()) {
				if (gender.equals("Male") || gender.equals("Female")) {
					return true;
				}
			}
		}
		return false;
	}
}