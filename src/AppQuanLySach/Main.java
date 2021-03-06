package AppQuanLySach;

import AppQuanLySach.Data.ListManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI/sample.fxml"));
        primaryStage.setTitle("App Quan Ly Sach");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();
    }

    public static void main(String[] args) {
        ListManager.getINSTANCE().reload();
        launch(args);
    }
}
