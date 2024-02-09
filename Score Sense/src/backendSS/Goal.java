package backendSS;

public class Goal {
	
	// Data fields
	private int minute;
	private String scorerName;
	private String assistName;
	private String teamName;

	// Default constructor
	public Goal() {

	}

	// Constructor 
	public Goal(int minute, String scorerName, String assistName, String teamName) {
		this.minute = minute;
		this.scorerName = scorerName;
		this.assistName = assistName;
		this.teamName = teamName;
	}

	// Getters
	public int getMinute() {
		return minute;
	}

	public String getScorerName() {
		return scorerName;
	}

	public String getAssistName() {
		return assistName;
	}

	public String getTeamName() {
		return teamName;
	}

	// Setters
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setScorerName(String scorerName) {
		this.scorerName = scorerName;
	}

	public void setAssistName(String assistName) {
		this.assistName = assistName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
