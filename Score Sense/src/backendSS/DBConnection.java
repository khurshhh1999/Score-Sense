package backendSS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//===================================================================================================================
	// Enter your ScoreSenseUsers.db (SQL lite file) path from the Score Sense folder: only modify after "jdbc:sqlite:/"
	//===================================================================================================================
	
	private static final String URL = "jdbc:sqlite:/C:/Users//mattd/eclipse-workspace/csye6200-workplace/Final_Project//ScoreSenseUsers.db/"; 
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}