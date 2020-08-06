package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {
    @FXML
    private TableView<Book> DisplayTable;
    @FXML private TextField titleField;
    @FXML private TextField langField;
    @FXML private TextField priceField;
    @FXML private TextField dateField;
    @FXML private TextField authorField;
    @FXML private TextField categoryField;
    @FXML private TextField publisherField;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();
    }


    public static void main(String[] args) {
        DataManager.loadList();
        launch(args);
    }
}
