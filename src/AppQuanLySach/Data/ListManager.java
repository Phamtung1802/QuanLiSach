package AppQuanLySach.Data;

import java.io.File;
import java.util.Collections;

public class ListManager {
    private static BookList dataList=new BookList();
    private static final ListManager dataInterface= new ListManager();

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
        Book editTarget=null;
        try {
            for (Book book : dataList) {
                if (ID.equals(book.getId())) {
                    index = book;
                    break;
                }
            }
            editTarget=dataList.get(dataList.indexOf(index));
            editTarget.setTitle(title);
            editTarget.setLang(lang);
            editTarget.setPrice(Long.parseLong(price));
            editTarget.setDate(date);
            editTarget.setAuthor(author);
            editTarget.setPublisher(publisher);
            editTarget.setCategory(category);
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
