package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1366, 768));
//
//        for (Book book:list){
//            data.add(book);
//        }
//        System.out.println(data.get(0));
//        System.out.println(DisplayTable.getItems().addAll(data));



        primaryStage.show();
    }


    public static void main(String[] args) {
        DataInterface.getINSTANCE().read();
//        for(Book book:DataInterface.getINSTANCE().getLib()){
//            System.out.println(book);
//        }

        launch(args);
    }
}
