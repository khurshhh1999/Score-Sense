package backendSS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;

public class MainController {

	
	//=================================================================================================
	//=================================================================================================
	
	// Setting up the league and team ComboBox choice list
	
	// FXML elements
	@FXML
	private ComboBox<String> leagueChoice;
	@FXML
	private ComboBox<String> teamChoice;
	
	
	// Creating HashMap data structures to store the league and teams lists
	private Map<String, String> leagueMap;
	private Map<String, Map<String, String>> teamsInLeaguesMap;
	private static UserProfile currentUserProfile;
	private boolean isHomePageUpdated = false;

	@FXML
	void initialize() {
		leagueMap = new HashMap<>();
		teamsInLeaguesMap = new HashMap<>();

		// Hashmap of the 5 european major football leagues
		
		leagueMap.put("Premier League", "2021");
		leagueMap.put("Ligue 1", "2015");
		leagueMap.put("Bundesliga", "2002");
		leagueMap.put("Serie A", "2019");
		leagueMap.put("La Liga", "2014");

		// Hashmap of teams within leagues
		
		// Premier League teams
		Map<String, String> premierLeagueTeams = new HashMap<>();
		premierLeagueTeams.put("Arsenal FC", "57");
		premierLeagueTeams.put("Aston Villa FC", "58");
		premierLeagueTeams.put("Chelsea FC", "61");
		premierLeagueTeams.put("Everton FC", "62");
		premierLeagueTeams.put("Fulham FC", "63");
		premierLeagueTeams.put("Liverpool FC", "64");
		premierLeagueTeams.put("Manchester City FC", "65");
		premierLeagueTeams.put("Manchester United FC", "66");
		premierLeagueTeams.put("Newcastle United FC", "67");
		premierLeagueTeams.put("Tottenham Hotspur FC", "73");
		premierLeagueTeams.put("Wolverhampton Wanderers FC", "76");
		premierLeagueTeams.put("Burnley FC", "328");
		premierLeagueTeams.put("Nottingham Forest FC", "351");
		premierLeagueTeams.put("Crystal Palace FC", "354");
		premierLeagueTeams.put("Sheffield United FC", "356");
		premierLeagueTeams.put("Luton Town FC", "389");
		premierLeagueTeams.put("Brighton & Hove Albion FC", "397");
		premierLeagueTeams.put("Brentford FC", "402");
		premierLeagueTeams.put("West Ham United FC", "563");
		premierLeagueTeams.put("AFC Bournemouth", "1044");
		
		// Bundesliga teams
		Map<String, String> bundesligaTeams = new HashMap<>();
		bundesligaTeams.put("1. FC Köln", "1");
		bundesligaTeams.put("TSG 1899 Hoffenheim", "2");
		bundesligaTeams.put("Bayer 04 Leverkusen", "3");
		bundesligaTeams.put("Borussia Dortmund", "4");
		bundesligaTeams.put("FC Bayern München", "5");
		bundesligaTeams.put("VfB Stuttgart", "10");
		bundesligaTeams.put("VfL Wolfsburg", "11");
		bundesligaTeams.put("SV Werder Bremen", "12");
		bundesligaTeams.put("1. FSV Mainz 05", "15");
		bundesligaTeams.put("FC Augsburg", "16");
		bundesligaTeams.put("SC Freiburg", "17");
		bundesligaTeams.put("Borussia Mönchengladbach", "18");
		bundesligaTeams.put("Eintracht Frankfurt", "19");
		bundesligaTeams.put("1. FC Union Berlin", "28");
		bundesligaTeams.put("VfL Bochum 1848", "36");
		bundesligaTeams.put("1. FC Heidenheim 1846", "44");
		bundesligaTeams.put("SV Darmstadt 98", "55");
		bundesligaTeams.put("RB Leipzig", "721");
		
		// Ligue 1 teams
		Map<String, String> ligue1Teams = new HashMap<>();
		ligue1Teams.put("Toulouse FC", "511");
		ligue1Teams.put("Stade Brestois 29", "512");
		ligue1Teams.put("Olympique de Marseille", "516");
		ligue1Teams.put("Montpellier HSC", "518");
		ligue1Teams.put("Lille OSC", "521");
		ligue1Teams.put("OGC Nice", "522");
		ligue1Teams.put("Olympique Lyonnais", "523");
		ligue1Teams.put("Paris Saint-Germain FC", "524");
		ligue1Teams.put("FC Lorient", "525");
		ligue1Teams.put("Stade Rennais FC 1901", "529");
		ligue1Teams.put("Le Havre AC", "533");
		ligue1Teams.put("Clermont Foot 63", "541");
		ligue1Teams.put("FC Nantes", "543");
		ligue1Teams.put("FC Metz", "545");
		ligue1Teams.put("Racing Club de Lens", "546");
		ligue1Teams.put("Stade de Reims", "547");
		ligue1Teams.put("AS Monaco FC", "548");
		ligue1Teams.put("RC Strasbourg Alsace", "576");
		
		// Serie A teams
		Map<String, String> serieATeams = new HashMap<>();
		serieATeams.put("AC Milan", "98");
		serieATeams.put("ACF Fiorentina", "99");
		serieATeams.put("AS Roma", "100");
		serieATeams.put("Atalanta BC", "102");
		serieATeams.put("Bologna FC 1909", "103");
		serieATeams.put("Cagliari Calcio", "104");
		serieATeams.put("Genoa CFC", "107");
		serieATeams.put("FC Internazionale Milano", "108");
		serieATeams.put("Juventus FC", "109");
		serieATeams.put("SS Lazio", "110");
		serieATeams.put("SSC Napoli", "113");
		serieATeams.put("Udinese Calcio", "115");
		serieATeams.put("Empoli FC", "445");
		serieATeams.put("Hellas Verona FC", "450");
		serieATeams.put("US Salernitana 1919", "455");
		serieATeams.put("Frosinone Calcio", "470");
		serieATeams.put("US Sassuolo Calcio", "471");
		serieATeams.put("Torino FC", "586");
		serieATeams.put("US Lecce", "5890");
		serieATeams.put("AC Monza", "5911");
		
		// La Liga teams
		Map<String, String> laLigaTeams = new HashMap<>();
		laLigaTeams.put("Athletic Club", "77");
		laLigaTeams.put("Club Atlético de Madrid", "78");
		laLigaTeams.put("CA Osasuna", "79");
		laLigaTeams.put("FC Barcelona", "81");
		laLigaTeams.put("Getafe CF", "82");
		laLigaTeams.put("Granada CF", "83");
		laLigaTeams.put("Real Madrid CF", "86");
		laLigaTeams.put("Rayo Vallecano de Madrid", "87");
		laLigaTeams.put("RCD Mallorca", "89");
		laLigaTeams.put("Real Betis Balompié", "90");
		laLigaTeams.put("Real Sociedad de Fútbol", "92");
		laLigaTeams.put("Villarreal CF", "94");
		laLigaTeams.put("Valencia CF", "95");
		laLigaTeams.put("Deportivo Alavés", "263");
		laLigaTeams.put("Cádiz CF", "264");
		laLigaTeams.put("UD Almería", "267");
		laLigaTeams.put("UD Las Palmas", "275");
		laLigaTeams.put("Girona FC", "298");
		laLigaTeams.put("RC Celta de Vigo", "558");
		laLigaTeams.put("Sevilla FC", "559");

		teamsInLeaguesMap.put("2021", premierLeagueTeams);
		teamsInLeaguesMap.put("2015", ligue1Teams);
		teamsInLeaguesMap.put("2014", laLigaTeams);
		teamsInLeaguesMap.put("2019", serieATeams);
		teamsInLeaguesMap.put("2002", bundesligaTeams);

		if (leagueChoice != null) {

			leagueChoice.setItems(FXCollections.observableArrayList(leagueMap.keySet()));
			leagueChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

				if (newSelection != null) {
					String leagueId = leagueMap.get(newSelection);
					updateTeamsDropdown(leagueId);
				}
			});
		}

	}

	private void updateTeamsDropdown(String leagueId) {
		Map<String, String> teamMap = teamsInLeaguesMap.get(leagueId);
		if (teamMap != null) {
			teamChoice.setItems(FXCollections.observableArrayList(teamMap.keySet()));
			teamChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			});

		} else {
			teamChoice.setItems(FXCollections.observableArrayList());
		}
	}

	
	//=================================================================================================
	//=================================================================================================
	
	// Scenes

	private Stage stage;
	private Scene scene;


	//=================================================================================================
	//=================================================================================================
	
	// SignUp (new user-registering) and go to Home page
	
	// FXML elements
	@FXML
	TextField newFirstName;
	@FXML
	TextField newLastName;
	@FXML
	TextField newEmail;
	@FXML
	TextField newPassword;
	@FXML
	JFXButton buttonSignUP;
	
	@FXML
	public void onScoreUPbuttonClicked(ActionEvent event) throws IOException, InterruptedException {
		String selectedLeagueName = leagueChoice.getValue();
		String selectedTeamName = teamChoice.getValue();
		String selectedLeagueId = leagueMap.get(selectedLeagueName);
		String selectedTeamId = teamsInLeaguesMap.get(selectedLeagueId).get(selectedTeamName);
		String firstName = newFirstName.getText();
		String lastName = newLastName.getText();
		String email = newEmail.getText();
		String password = newPassword.getText();

		UserProfile userProfile = new UserProfile(firstName, lastName, email, password, selectedLeagueId,
				selectedTeamId);
		UserProfileDAO dao = new UserProfileDAO();

		boolean isSaved = dao.saveUserProfile(userProfile);
		if (isSaved) {
			currentUserProfile = dao.getUserProfile(email);
			UserProfileManager.getInstance().setCurrentUserProfile(currentUserProfile);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
			Parent root = loader.load();

			MainController homeController = loader.getController();
			homeController.setUserProfile(currentUserProfile);
			// homeController.updateTeamLogos(homeTeamName.getText(),
			// awayTeamName.getText());

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			System.out.println("Failed to create profile for user: " + email);
		}

	}


	//=================================================================================================
	//=================================================================================================
	
	// SignIN (existing user) and go to Home page
	
	// FXML elements
	@FXML
	TextField existingEmail;
	@FXML
	TextField existingPassword;
	@FXML
	JFXButton buttonSignIN;
	@FXML
	Button buttonProfile;
	@FXML
	Button buttonLogOut1;
	@FXML
	ImageView homeTeamLogo = new ImageView();
	@FXML
	ImageView awayTeamLogo = new ImageView();
	@FXML
	Label homeTeamName;
	@FXML
	Label homeTeamScore;
	@FXML
	Label homeTeamScorers;
	@FXML
	Label gameDate;
	@FXML
	Label awayTeamName;
	@FXML
	Label awayTeamScore;
	@FXML
	Label awayTeamScorers;
	@FXML
	Label nextFanFixture1;
	@FXML
	Label nextFanFixture2;
	
	
	// Method to load a current profile
	public void setUserProfile(UserProfile userProfile) throws InterruptedException {
		MainController.currentUserProfile = userProfile;
		if (MainController.currentUserProfile != null) {
			updateHomePageWithMatches();
		}
	}
	
	// Method that fetches the API data and displays it on the Home page
	public void updateHomePageWithMatches() throws InterruptedException {
		if (isHomePageUpdated)
			return;
		String leagueId = currentUserProfile.getFavoriteLeague();
		String teamId = currentUserProfile.getFavoriteTeam();

		String leagueMatchesJson = FootballDataAPI.getMatchesForTeamOrLeague(teamId, leagueId);
		List<Match> leagueMatches = MatchDataParser.parseMatchData(leagueMatchesJson);

		Match liveMatch = null;
		List<Match> upcomingMatches = new ArrayList<>();

		for (Match match : leagueMatches) {
			if ("IN_PLAY".equals(match.getStatus()) || "PAUSED".equals(match.getStatus())) {
				
				// Assuming there is only one live match at a time
				liveMatch = match;
				
			} else if ("TIMED".equals(match.getStatus()) || "SCHEDULED".equals(match.getStatus())) {
				upcomingMatches.add(match);
			}
		}

		// Update UI for the live match
		if (liveMatch != null) {
			
			// Update team names and scores
			homeTeamName.setText(liveMatch.getTeamHome());
			homeTeamScore.setText(String.valueOf(liveMatch.getScoreHome()));
			awayTeamName.setText(liveMatch.getTeamAway());
			awayTeamScore.setText(String.valueOf(liveMatch.getScoreAway()));
			updateHomeAndAwayTeamsLogos(homeTeamName.getText(), awayTeamName.getText());

			// Display goal scorers for each team
			StringBuilder homeScorers = new StringBuilder();
			StringBuilder awayScorers = new StringBuilder();

			for (Goal goal : liveMatch.getGoals()) {
				String scorerInfo = goal.getScorerName() + " (" + goal.getMinute() + "'), ";
				if (goal.getTeamName().equals(liveMatch.getTeamHome())) {
					homeScorers.append(scorerInfo);
				} else if (goal.getTeamName().equals(liveMatch.getTeamAway())) {
					awayScorers.append(scorerInfo);
				}
			}

			homeTeamScorers.setText(homeScorers.toString());
			awayTeamScorers.setText(awayScorers.toString());
		}

		if (!upcomingMatches.isEmpty()) {
			Match nextMatch = upcomingMatches.get(0);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm");
			homeTeamName.setText(nextMatch.getTeamHome());
			homeTeamScore.setText("0");
			awayTeamName.setText(nextMatch.getTeamAway());
			awayTeamScore.setText("0");
			homeTeamScorers.setText("Yet to play");
			awayTeamScorers.setText("Yet to play");
			updateHomeAndAwayTeamsLogos(homeTeamName.getText(), awayTeamName.getText());
			gameDate.setText(formatter.format(nextMatch.getDate()));

			if (nextFanFixture1 != null && upcomingMatches.size() > 0) {
				Match firstMatch = upcomingMatches.get(1);

				// "Newcastle vs Manchester United&#10;Premier League &#10;Saturday, 2
				// December&#10;3:00 PM"
				nextFanFixture1.setText(firstMatch.getTeamHome() + " vs " + firstMatch.getTeamAway() + "\n"
						+ formatter.format(firstMatch.getDate()));
			}

			if (nextFanFixture2 != null && upcomingMatches.size() > 1) {
				Match secondMatch = upcomingMatches.get(2);
				nextFanFixture2.setText(secondMatch.getTeamHome() + " vs " + secondMatch.getTeamAway() + "\n"
						+ formatter.format(secondMatch.getDate()));
			}

		}
		isHomePageUpdated = true;
	}
	
	
	@FXML
	private void onScoreINbuttonClicked(ActionEvent event) throws IOException, InterruptedException {
		String email = existingEmail.getText();
		String password = existingPassword.getText();
		UserProfileDAO dao = new UserProfileDAO();
		dao.getUserProfile(email);
		boolean userExists = dao.verifyUser(email, password);
		
		if (userExists) {
			currentUserProfile = dao.getUserProfile(email);
			UserProfileManager.getInstance().setCurrentUserProfile(currentUserProfile);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
			Parent root = loader.load();

			MainController homeController = loader.getController();
			homeController.setUserProfile(currentUserProfile);

			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}


	public void onSceneLoaded() throws InterruptedException {
		if (currentUserProfile != null) {
			updateHomePageWithMatches();
		}
	}



	// Method used in updateHomeAndAwayTeamsLogos to load on the UI the Home page main game team logos
	private void updateHomeAndAwayTeamsLogos(String homeTeam, String awayTeam) {
		
		// TeamLogos are stored in a folder named "Images/Teams" with filenames like
		// "TeamName.png"
		String homeTeamLogoPath = "Images/Teams/" + homeTeam + ".png";
		String awayTeamLogoPath = "Images/Teams/" + awayTeam + ".png";

		Image homeTeamLogoImage = new Image(homeTeamLogoPath);
		Image awayTeamLogoImage = new Image(awayTeamLogoPath);

		homeTeamLogo.setImage(homeTeamLogoImage);
		awayTeamLogo.setImage(awayTeamLogoImage);
	}



	
	//=================================================================================================
	//=================================================================================================
	
	// Go to Home page
	
	// Triggered by JFX buttons "Back to Scores" (action: go to Home page) 	
	public void switchToHomePage(ActionEvent event) throws IOException, InterruptedException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Home.fxml"));
		Parent root = loader.load();

		MainController homeController = loader.getController();
		homeController.setUserProfile(currentUserProfile);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		homeController.onSceneLoaded();
	}

	//=================================================================================================
	//=================================================================================================
	
	// Go to Profile page
	
	// FXML elements
	@FXML
	JFXButton buttonBackToScores;
	@FXML
	JFXButton buttonLogOUT;
	@FXML
	ImageView clubFanLogo = new ImageView();
	@FXML
	ImageView leagueFanLogo = new ImageView();
	@FXML
	Label firstName;
	@FXML
	Label lastName;
	@FXML
	Label emailAddress;
	@FXML
	Label userID;
	
	// Methods getLeagueNameById & getTeamNameById are used in switchToProfilePage()
	private String getLeagueNameById(String leagueId) {
		for (Map.Entry<String, String> entry : leagueMap.entrySet()) {
			if (entry.getValue().equals(leagueId)) {
				return entry.getKey();
			}
		}
		
		// Return an empty string or handle accordingly if league ID is not found
		return ""; 
	}

	private String getTeamNameById(String teamId) {
		for (Map.Entry<String, Map<String, String>> leagueEntry : teamsInLeaguesMap.entrySet()) {
			Map<String, String> teamsInLeague = leagueEntry.getValue();
			for (Map.Entry<String, String> teamEntry : teamsInLeague.entrySet()) {
				if (teamEntry.getValue().equals(teamId)) {
					return teamEntry.getKey();
				}
			}
		}
		
		// Return an empty string or handle accordingly if team ID is not found
		return ""; 
	}
	
	// Triggered by JFX buttons "profile icons" (action: go to Profile page)	
	public void switchToProfilePage(ActionEvent event) throws IOException, InterruptedException {
		UserProfileManager.getInstance().setCurrentUserProfile(currentUserProfile);

		Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));

		// Set the labels with the user information
		Label firstNameLabel = (Label) root.lookup("#firstName");
		Label lastNameLabel = (Label) root.lookup("#lastName");
		Label emailAddressLabel = (Label) root.lookup("#emailAddress");

		firstNameLabel.setText(currentUserProfile.getFirstName());
		lastNameLabel.setText(currentUserProfile.getLastName());
		emailAddressLabel.setText(currentUserProfile.getEmail());

		// Set the Favorite Team and League pictures
		String favoriteLeague = getLeagueNameById(currentUserProfile.getFavoriteLeague());
		String favoriteTeam = getTeamNameById(currentUserProfile.getFavoriteTeam());
		String favoriteTeamLogoPath = "Images/Teams/" + favoriteTeam + ".png";
		String favoriteLeagueLogoPath = "Images/Leagues/" + favoriteLeague + ".png";

		Image favoriteTeamLogoImage = new Image(favoriteTeamLogoPath);
		Image favoriteLeagueLogoImage = new Image(favoriteLeagueLogoPath);

		ImageView clubFanLogoImageView = (ImageView) root.lookup("#clubFanLogo");
		ImageView leagueFanLogoImageView = (ImageView) root.lookup("#leagueFanLogo");

		clubFanLogoImageView.setImage(favoriteTeamLogoImage);
		leagueFanLogoImageView.setImage(favoriteLeagueLogoImage);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//=================================================================================================
	//=================================================================================================
	
	// Go to LogIN page
	
	
	// Triggered by JFX buttons "Log OUT" (action: go to LogIN page)	
	public void switchToLogINPage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogIN.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// Triggered by JFX buttons "League" (action: go to LeagueStandings page)	
	public void switchToLeagueStandings(ActionEvent event) throws IOException, InterruptedException {
		UserProfileManager.getInstance().setCurrentUserProfile(currentUserProfile);

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LeagueStandings.fxml"));
		Parent root = loader.load();

		// Set the League Name with the user information
		Label leagueNameLabel = (Label) root.lookup("#leagueName");

		// Set the Favorite League label and picture
		String favoriteLeague = getLeagueNameById(currentUserProfile.getFavoriteLeague());
		leagueNameLabel.setText(favoriteLeague);

		String favoriteLeagueLogoPath = "Images/Leagues/" + favoriteLeague + ".png";
		Image favoriteLeagueLogoImage = new Image(favoriteLeagueLogoPath);

		ImageView leagueFanLogoImageView = (ImageView) root.lookup("#leagueLogo");
		leagueFanLogoImageView.setImage(favoriteLeagueLogoImage);

		// Set the League standings, teams via the API
		String leagueMatchesJson = FootballDataAPI.getLeagueStandingsForLeague(currentUserProfile.getFavoriteLeague());
		List<LeagueStandings> teamNames = LeagueStandingsParser.parseLeagueStandingsData(leagueMatchesJson,
				favoriteLeague);

		// Generate Label references for team names
		for (int i = 0; i < teamNames.size(); i++) {
			Label teamNameLabel = (Label) root.lookup("#team" + (i + 1) + "Name");
			ImageView leagueStandingsLogoImageView = (ImageView) root.lookup("#team" + (i + 1) + "Logo");

			try {
				// Set the Teams name through the Label
				String methodName = "getTeam" + (i + 1) + "Name";
				String teamName = (String) LeagueStandings.class.getMethod(methodName).invoke(teamNames.get(i));
				teamNameLabel.setText(teamName);

				// Set the image for the ImageView
				String teamLogoPath = "Images/Teams/" + teamName + ".png";
				Image teamLogoImage = new Image(teamLogoPath);
				leagueStandingsLogoImageView.setImage(teamLogoImage);

			} catch (Exception e) {
				e.printStackTrace();
				teamNameLabel.setText("N/A");
			}
		}

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
