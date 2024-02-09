package backendSS;

public class Booking {
	private int minute;
	private String playerName;
	private String cardType;
	private String teamName;

	public Booking() {

	}

	public Booking(int minute, String playerName, String cardType, String teamName) {
		this.minute = minute;
		this.playerName = playerName;
		this.cardType = cardType;
		this.teamName = teamName;
	}

	public int getMinute() {
		return minute;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getCardType() {
		return cardType;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}