package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements javafx.fxml.Initializable  {

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
    @FXML private TextField id;
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
        DataController.getINSTANCE().editBook(id.getText(),name.getText(),lang.getText(),price.getText(),date.getText(),author.getText(),publisher.getText(),category.getText());
        Stage stage = (Stage) save.getScene().getWindow();
        Controller.changeTable(Controller.list);
        stage.close();
    }
    public void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    public void findId(){
        Book index=null;
        try {
            for (Book book : list) {
                if (id.getText().equals(book.getId())) {
                    index = book;
                    break;
                }
            }
            name.setText(list.get(list.indexOf(index)).getTitle());
            lang.setText(list.get(list.indexOf(index)).getLang());
            price.setText(Long.toString(list.get(list.indexOf(index)).getPrice()));
            date.setText(list.get(list.indexOf(index)).getDate());
            author.setText(list.get(list.indexOf(index)).getAuthor());
            publisher.setText(list.get(list.indexOf(index)).getPublisher());
            category.setText(list.get(list.indexOf(index)).getCategory());

        }catch (IndexOutOfBoundsException e){
            name.setText("");
            lang.setText("");
            price.setText("");
            date.setText("");
            author.setText("");
            publisher.setText("");
            category.setText("");
            System.out.println("khong tim thay");
        }
    }
    public void delete(){
        try {
            DataController.getINSTANCE().removeBook(Integer.parseInt(id.getText()) - 1);
        }catch (NumberFormatException e){

        }
        Controller.list= DataController.getINSTANCE().getLib();
        Controller.changeTable(Controller.list);
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

}
