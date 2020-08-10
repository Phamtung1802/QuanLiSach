package AppQuanLySach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addController implements javafx.fxml.Initializable  {

    @FXML
    private TextField name;

    @FXML
    private TextField lang;

    @FXML
    private TextField price;

    @FXML
    private TextField date;

    @FXML
    private TextField author;

    @FXML
    private TextField publisher;

    @FXML
    private TextField category;
    @FXML
    Button save;
    @FXML
    Button cancel;

    BookList list= DataController.getINSTANCE().getLib();
    ObservableList<Book> datalist = FXCollections.observableArrayList();

    //    fx:controller="sample.Controller"
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void save() {
        DataController.getINSTANCE().addBook(Integer.toString(list.size()+1),name.getText(),lang.getText(),Long.parseLong(price.getText()),date.getText(),author.getText(),publisher.getText(),category.getText());
        Stage stage = (Stage) save.getScene().getWindow();
        Controller.changeTable(Controller.list);
        stage.close();
    }
    public void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

}
