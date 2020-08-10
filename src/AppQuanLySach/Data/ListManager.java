package AppQuanLySach.Data;

import java.io.File;
import java.util.Collections;

public class ListManager {
    private static BookList dataList=new BookList();
    private static final ListManager dataInterface= new ListManager();
    private static Integer idPool;

    private ListManager(){

    }

    public static ListManager getINSTANCE() {
        return dataInterface;
    }

    public void removeBook(int index){
        dataList.remove(index);
        DataManager.WriteFile(dataList,false);
        reload();
    }

    public BookList addBook(String id,String title,String lang, long price, String date, String author, String publisher, String category){
        dataList.add(new Book(id,lang,title,price,date,author,publisher,category));
        Collections.sort(dataList);
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
        Collections.sort(dataList);
        return dataList;
    }


    public void reload(){
        dataList=DataManager.loadList();
    }

    public BookList getLib() {
        return dataList;
    }

    public void appendList(File csvFile){
        DataManager.appendFile(csvFile,dataList);
        reload();
        DataManager.WriteFile(dataList,false);
        Collections.sort(dataList);
        reload();
    }
}
