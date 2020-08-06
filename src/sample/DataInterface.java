package sample;

import java.io.File;

public class DataInterface {
    private static BookList dataList=new BookList();
    private static final DataInterface dataInterface= new DataInterface();

    private DataInterface(){

    }

    public static DataInterface getINSTANCE() {
        return dataInterface;
    }

    public BookList addBook(String id,String title,String lang, long price, String date, String author, String publisher, String category){
        dataList.add(new Book(id,lang,title,price,date,author,publisher,category));
        DataManager.WriteFile(dataList,false);
        return dataList;
    }

    public void read(){
        dataList=DataManager.loadList();
    }

    public BookList getLib() {
        return dataList;
    }

    public void appendList(File csvFile){
        DataManager.appendFile(csvFile,dataList);
        read();
        DataManager.WriteFile(dataList,false);
    }

}
