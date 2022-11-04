public class ReaderMain {
    public static void main(String[] args) {
        ReaderInfo reader = new ReaderInfo();

        reader.setFio("Петров В.В.");
        reader.takeBook(3);
        String[] book_name = {"Приключения", "Словарь", "Энциклопедия"};
        reader.takeBook(book_name);

        //st1.takeBook("Мизери");

        //st1.returnBook("Код да-винчи");

    }
}