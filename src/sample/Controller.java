package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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

    BookList list=DataInterface.getINSTANCE().getLib();
    ObservableList<Book> datalist = FXCollections.observableArrayList();
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
                    onSearch();
                }
        );
        DisplayTable.setItems(datalist);

    }
    public void changeTable(BookList list){
        datalist.clear();
        datalist.addAll(list);
    }

    public void onSearch(){
        if (oTimkiem.getText()==""){
            changeTable(list);
        }else {
            changeTable(DataManager.iterateList(oTimkiem.getText(),list,filterBox.getValue()));
        }
    }

}
