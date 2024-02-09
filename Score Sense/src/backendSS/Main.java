package backendSS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIN.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 900, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			// MainController ensures the scene to load and initialize, please remember for
			// onSignIN
			
			primaryStage.setOnShown(event -> {
				MainController controller = loader.getController();
				if (controller != null) {
					try {
						controller.onSceneLoaded();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}