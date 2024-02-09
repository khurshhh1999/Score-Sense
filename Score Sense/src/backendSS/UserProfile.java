package backendSS;

public class UserProfile {
	
	// Data fields
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String favoriteLeague;
	private String favoriteTeam;

	// Constructor
	public UserProfile(String firstName, String lastName, String email, String password, String favoriteLeague,
			String favoriteTeam) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.favoriteLeague = favoriteLeague;
		this.favoriteTeam = favoriteTeam;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFavoriteLeague() {
		return favoriteLeague;
	}

	public String getFavoriteTeam() {
		return favoriteTeam;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFavoriteLeague(String favoriteLeague) {
		this.favoriteLeague = favoriteLeague;
	}

	public void setFavoriteTeam(String favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}
}
