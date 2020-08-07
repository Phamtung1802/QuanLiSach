package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataInterface {
    private static BookList dataList=new BookList();
    private static final DataInterface dataInterface= new DataInterface();
    private static Integer idPool;

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
