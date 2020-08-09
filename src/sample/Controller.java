package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements javafx.fxml.Initializable  {
    @FXML
    private TableView<Book> DisplayTable;
    @FXML
    private TableColumn<Book, String> id;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private TableColumn<Book, String>  lang;

    @FXML
    private TableColumn<Book, String>  price;

    @FXML
    private TableColumn<Book, String>  date;

    @FXML
    private TableColumn<Book, String>  author;

    @FXML
    private TableColumn<Book, String>  publisher;

    @FXML
    private TableColumn<Book, String>  category;

    @FXML private TextField oTimkiem;

    @FXML private ChoiceBox<String> filterBox;
    @FXML private void edit(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Edit.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Sửa");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML private void addToList() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Popup.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Thêm Tựa Sách");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static BookList list=DataInterface.getINSTANCE().getLib();
    public static ObservableList<Book> datalist = FXCollections.observableArrayList();
    String filterString;


//    fx:controller="sample.Controller"
    public void initialize(URL location, ResourceBundle resources) {
        datalist.addAll(list);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        lang.setCellValueFactory(new PropertyValueFactory<>("lang"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        filterBox.setItems(FXCollections.observableArrayList("ID", "Tên Sách","Ngôn Ngữ","Ngày Xuất Bản","Tác Giả","Nhà Xuất Bản","Thể Loại","Giá Tiền"));
        filterBox.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue)-> {
                    filterString = newValue;
                    System.out.println(filterBox.getValue());
                    onSearch();
                }
        );


        DisplayTable.setItems(datalist);

    }
    public static void changeTable(BookList list){
        datalist.clear();
        datalist.addAll(list);
    }

    public void onSearch(){
        try{
            System.out.println(oTimkiem.getText());

            if (oTimkiem.getText()==""){
                changeTable(list);
            }else {
                changeTable(DataManager.iterateList(oTimkiem.getText(),list,filterBox.getValue()));
            }
        }catch (NullPointerException e){
            System.out.println("null");
        }
    }

    public void quickAdd(){
        try {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            DataInterface.getINSTANCE().appendList(selectedFile);
            list = DataInterface.getINSTANCE().getLib();
            datalist.clear();
            datalist.addAll(list);
        }catch (NullPointerException e){

        }
    }

}
