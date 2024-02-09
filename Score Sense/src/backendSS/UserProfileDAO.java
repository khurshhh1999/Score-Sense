package backendSS;

import java.sql.*;

public class UserProfileDAO {
	
	// Method to store a new user's information on the database
	public boolean saveUserProfile(UserProfile profile) {
		String sql = "INSERT INTO users (firstName, lastName, email, password, favoriteLeague, favoriteTeam) VALUES (?, ?, ?, ?, ?, ?)";
		boolean rowInserted = false;
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, profile.getFirstName());
			pstmt.setString(2, profile.getLastName());
			pstmt.setString(3, profile.getEmail());
			pstmt.setString(4, profile.getPassword());
			pstmt.setString(5, profile.getFavoriteLeague());
			pstmt.setString(6, profile.getFavoriteTeam());
			rowInserted = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		}
		return rowInserted;
	}

	
	// Method to retrieve an existing user's information from the email on the database
	public UserProfile getUserProfile(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new UserProfile(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("password"), rs.getString("favoriteLeague"), rs.getString("favoriteTeam"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean verifyUser(String email, String password) {
		String SELECT_USER_SQL = "SELECT * FROM users WHERE email = ? AND password = ?;";

		try (Connection conn = DBConnection.connect();
				PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_SQL)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				boolean userExists = resultSet.next();
				return userExists;
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
			return false;
		}
	}
	
	
	//=================================================================================================
	//=================================================================================================
	
	// Possible future implementations
	
	
	// Method enabling modifying user's information on the database
	public void updateUserProfile(UserProfile profile) {
		String sql = "UPDATE users SET firstName = ? , lastName = ?, password = ?, favoriteLeague = ?, favoriteTeam = ? WHERE email = ?";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, profile.getFirstName());
			pstmt.setString(2, profile.getLastName());
			pstmt.setString(3, profile.getEmail());
			pstmt.setString(4, profile.getPassword());
			pstmt.setString(5, profile.getFavoriteLeague());
			pstmt.setString(6, profile.getFavoriteTeam());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Method enabling to delete a user from the database
	public void deleteUserProfile(String email) {
		String sql = "DELETE FROM users WHERE email = ?";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
