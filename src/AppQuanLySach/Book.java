package AppQuanLySach;

public class Book implements Comparable<Book>{
        private String title;
        private long price;
        private String date;
        private String author;
        private String publisher;
        private String category;
        private String id;
        private String lang;

        public Book(String iD,String title,String lang, long price, String date, String author, String publisher, String category) {
            this.title = title;
            this.price = price;
            this.date = date;
            this.author = author;
            this.publisher = publisher;
            this.category= category;
            this.lang=lang;
            this.id =iD;
        }

        @Override
        public String toString(){
            return  "Name "+ this.getTitle()+"\n"+
                    "Language "+ this.getLang()+"\n"+
                    "Author "+ this.getAuthor()+"\n"+
                    "Date "+ this.getDate()+"\n"+
                    "Price "+ this.getPrice()+"\n"+
                    "Publisher "+this.getPublisher()+"\n"+
                    "Category "+ this.getCategory()+"\n";

        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }



    @Override
    public int compareTo(Book o) {
        if(Integer.parseInt(this.getId())==Integer.parseInt(o.getId())){
            return 0;
        }
        if(Integer.parseInt(this.getId())>Integer.parseInt(o.getId())){
            return 1;
        }
        else{
            return -1;
        }

    }
}
