public class Book {
    String author;
    String book;

    Book(String author, String book){
        this.author = author;
        this.book = book;
    }

    Book book1 = new Book("Рэй Брэдберри", "И грянул гром");
    Book book2 = new Book("Джордж Оруэлл", "1984");
}
