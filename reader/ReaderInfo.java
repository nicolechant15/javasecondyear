public class ReaderInfo{
    String fio;
    int readers_card_number;
    String faculty;
    String date_of_birth;
    String phone_number;

    public void setFio(String fio){
        this.fio = fio;
    }

    public void setReaders_card_number(int readers_card_number){
        this.readers_card_number = readers_card_number;
    } // не знаю это нужно вообще или нет, если нигде не используется все равно.. (относится и к факультету, дате
    // рождения, номеру телефона)

    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public void setDate_of_birth(String date_of_birth){
        this.date_of_birth = date_of_birth;
    }

    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }

    public String getFio(){
        return fio;
    }

    public int getReaders_card_number(){
        return readers_card_number;
    }

    public String getFaculty(){
        return faculty;
    }

    public String getDate_of_birth(){
        return date_of_birth;
    }

    public String getPhone_number(){
        return phone_number;
    }

    public void takeBook(int amount_of_books){
        System.out.println(fio + " взял " + amount_of_books + " книги");
    }

    public void returnBook(int amount_of_books){
        System.out.println(fio + " вернул " + amount_of_books + " книги");
    }

    public void takeBook(String[] book_name){
        String s = "";
        for (String i: book_name){
            s += i + ", ";
        }
        System.out.println(fio + " взял книги: " + s);
    }

    public void returnBook(String[] book_name) {
        String s = "";
        for (String i : book_name) {
            s += i + ", ";
        }
        System.out.println(fio + " вернул книги: " + s);
    }
}
