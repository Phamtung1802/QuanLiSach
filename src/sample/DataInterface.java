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
    public BookList editBook(String ID,String title,String lang, String price, String date, String author, String publisher, String category){
        Book index=null;
        try {
            for (Book book : dataList) {
                if (ID.equals(book.getId())) {
                    index = book;
                    break;
                }
            }
            dataList.get(dataList.indexOf(index)).setTitle(title);
            dataList.get(dataList.indexOf(index)).setLang(lang);
            dataList.get(dataList.indexOf(index)).setPrice(Long.parseLong(price));
            dataList.get(dataList.indexOf(index)).setDate(date);
            dataList.get(dataList.indexOf(index)).setAuthor(author);
            dataList.get(dataList.indexOf(index)).setPublisher(publisher);
            dataList.get(dataList.indexOf(index)).setCategory(category);
            DataManager.WriteFile(dataList, false);
        }catch (IndexOutOfBoundsException e){
            System.out.println("khong thay");
        }
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
