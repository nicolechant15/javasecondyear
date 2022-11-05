public class ReaderMain {
    public static void main(String[] args) {
        ReaderInfo reader = new ReaderInfo();

        reader.setFio("Петров В.В.");
        reader.takeBook(3);
        reader.returnBook(3);
        String[] book_name = {"Приключения", "Словарь", "Энциклопедия"};
        reader.takeBook(book_name);
        reader.returnBook(book_name);
    }
}