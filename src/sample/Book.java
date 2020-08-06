package sample;

public class Book {
        private String title;
        private long price;
        private String date;
        private String author;
        private String publisher;
        private String category;
        private String iD;
        private String lang;

        public Book(String iD,String title,String lang, long price, String date, String author, String publisher, String category) {
            this.title = title;
            this.price = price;
            this.date = date;
            this.author = author;
            this.publisher = publisher;
            this.category= category;
            this.lang=lang;
            this.iD=iD;
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

        public String getiD() {
            return iD;
        }

        public void setiD(String iD) {
            this.iD = iD;
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

}
