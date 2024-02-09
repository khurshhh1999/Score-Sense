package backendSS;

public class UserProfileManager {
	
	// Data fields
	private static UserProfileManager instance;
	private UserProfile currentUserProfile;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String favoriteLeague;
	private String favoriteTeam;

	// Default constructor
	private UserProfileManager() {
	}
	
	// Constructor
	public static UserProfileManager getInstance() {
		if (instance == null) {
			instance = new UserProfileManager();
		}
		return instance;
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFavoriteLeague(String favoriteLeague) {
		this.favoriteLeague = favoriteLeague;
	}

	public void setFavoriteTeam(String favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}

	public void setCurrentUserProfile(UserProfile userProfile) {
		this.currentUserProfile = userProfile;
	}

	// Getters
	public UserProfile getCurrentUserProfile() {
		return currentUserProfile;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFavoriteLeague() {
		return favoriteLeague;
	}

	public String getFavoriteTeam() {
		return favoriteTeam;
	}

}
