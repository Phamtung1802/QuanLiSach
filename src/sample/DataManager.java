package sample;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataManager implements Serializable {

    private synchronized void IDGenerator(){

    }

    private static FileReader getReader(File getIDFile) {
        File IDcode=getIDFile;
        FileReader input = null;
        try {
            input=new FileReader(IDcode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private static FileWriter getWriter(File getIDFile, boolean doesAppend) {
        File IDcode = getIDFile;
        FileWriter output=null;
        try {
            if(doesAppend==false) {
                output = new FileWriter(IDcode);
            }
            else {
                output=new FileWriter(IDcode,true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void WriteFile(BookList list,boolean doesAppend) {
        FileWriter writer=getWriter(getIDFile(),doesAppend);
        for(Book book:list) {
            try {
                writer.write(book.getId()+","+book.getTitle()+","+book.getLang()+","+book.getPrice()+","+book.getDate()+","+book.getAuthor()+","+book.getLang()+","+book.getPublisher()+","+book.getCategory()+"\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("loi");
            }
        }
        try {
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("loi");
        }
    }



    public static void appendFile(File csvFile, BookList list)  {
        FileWriter writer=getWriter(getIDFile(),true);
        FileReader reader=getReader(csvFile);
        StringBuffer data=new StringBuffer("");
        int code=-1;
        try {
            while ((code =reader.read())!= -1) {
                data.append((char)code);
            }
            reader.close();
            writer.append(data);
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static BookList loadList()  {
        BookList list=new BookList();
        FileReader reader=getReader(getIDFile());
        StringBuffer data=new StringBuffer("");
        try {int a=-1;
            while((a=reader.read())!=-1) {
                data.append((char) a);
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] newdata=data.toString().split("\n");
        if(newdata.length>1) {
            for (int i = 0; i < newdata.length; i++) {
                String[] tempstr = newdata[i].split(",");
                list.add(new Book(tempstr[0],tempstr[1], tempstr[2], Long.parseLong(tempstr[3]), tempstr[4], tempstr[5], tempstr[6], tempstr[7]));
            }
        }
        return list;
    }


    private static File getIDFile(){
        File IDcode=null;
        try {
            IDcode = new File("Libary.txt");
            if (!IDcode.exists()) {
                IDcode.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return IDcode;
    }


    public static BookList iterateList(String value, BookList dataList,String filter){
        BookList temp=new BookList();
        String regex = ".*"+value+".*";
        Pattern pattern= Pattern.compile(regex);
        String stringToBeMatched;
        Matcher matcher;
        if(filter.equals("ID")) {
            for (Book book : dataList) {
                stringToBeMatched =book.getId();
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        else if(filter.equals("Tên Sách")) {
            for (Book book : dataList) {
                stringToBeMatched = book.getTitle();
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        else if(filter.equals("Ngôn Ngữ")) {
            for (Book book : dataList) {
                stringToBeMatched = book.getLang();
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }

        else if(filter.equals("Tác Giả")) {
            for (Book book : dataList) {
                stringToBeMatched = book.getAuthor();
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        else if(filter.equals("Nhà Xuất Bản")) {
            for (Book book : dataList) {
                stringToBeMatched = book.getPublisher();
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        else if(filter.equals("Thể Loại")) {
            String regex2 = ".*"+value+".*[^/n]";
            Pattern pattern2= Pattern.compile(regex2);
            for (Book book : dataList) {
                stringToBeMatched = book.getCategory();
                matcher = pattern2.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        else if(filter.equals("Giá Tiền")) {
            for (Book book : dataList) {
                stringToBeMatched = Long.toString(book.getPrice());
                matcher = pattern.matcher(stringToBeMatched);
                if (matcher.matches()) {
                    temp.add(book);
                }
            }
        }
        return temp;
    }
}
