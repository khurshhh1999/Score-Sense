package backendSS;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Match {
	
	// Data fields
	private String teamHome;
	private String teamAway;
	private int scoreHome;
	private int scoreAway;
	private String status;
	private List<Goal> goals;
	private List<Booking> bookings;
	private List<String> goalScorers;
	private List<String> yellowCards;
	private List<String> redCards;
	private LocalDateTime date;
	private String count;

	// Default constructor
	public Match() {
	}

	// public Match(String date, String teamHome, String teamAway, int scoreHome,
	// int scoreAway) {
	// this.date = date;
	// this.teamHome = teamHome;
	// this.teamAway = teamAway;
	// this.scoreHome = scoreHome;
	// this.scoreAway = scoreAway;
	// }

	// Getters
	public String getCount() {
		return count;
	}

	public String getTeamHome() {
		return teamHome;
	}

	public String getTeamAway() {
		return teamAway;
	}

	public int getScoreHome() {
		return scoreHome;
	}

	public int getScoreAway() {
		return scoreAway;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	// Setters
	public void setDate(String dateString) {
		this.date = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
	}

	public void setTeamHome(String teamHome) {
		this.teamHome = teamHome;
	}

	public void setCount(String c) {
		this.count = c;
	}

	public void setTeamAway(String teamAway) {
		this.teamAway = teamAway;
	}

	public void setScoreHome(int scoreHome) {
		this.scoreHome = scoreHome;
	}

	public void setScoreAway(int scoreAway) {
		this.scoreAway = scoreAway;
	}

	public List<String> getGoalScorers() {
		return goalScorers;
	}

	public void setGoalScorers(List<String> goalScorers) {
		this.goalScorers = goalScorers;
	}

	public List<String> getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(List<String> yellowCards) {
		this.yellowCards = yellowCards;
	}

	public List<String> getRedCards() {
		return redCards;
	}

	public void setRedCards(List<String> redCards) {
		this.redCards = redCards;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString method
	@Override
	public String toString() {
		return "Match{" + "teamHome='" + getTeamHome() + '\'' + ", teamAway='" + getTeamAway() + '\'' + ", scoreHome="
				+ scoreHome + ", scoreAway=" + scoreAway + ", status='" + status + '\'' + ", date=" + date + ", count="
				+ count + '}';
	}

}
