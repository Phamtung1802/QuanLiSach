package AppQuanLySach;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static final String SECOND_SCREEN_FXML = "Popup.fxml";



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("App Quan Ly Sach");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {
        DataController.getINSTANCE().read();
        launch(args);
    }
}
