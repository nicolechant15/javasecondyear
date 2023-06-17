import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Класс WeekNumber отвечает за номер недели
 * */
public class WeekNumber {
    /**
     * Основной метод, которые выводит на экран номер недели, согласно введеной дате в формате строки
     * @param args принимает стороковые параметры
     * @exception ParseException возвращает ParseException при ошибке во время парсига
     * */
    public static void main(String[] args) throws ParseException {
        // в формате строки вводим небходимую дату
        String dateStr = "03.01.23";
        // определяем формат даты
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        // определяем калдарь на основе местоположения
        Calendar calendar = Calendar.getInstance();
        // парсим строковую дату, чтобы она приняла формат, указанный выше
        Date date = sdf.parse(dateStr);
        // задаем время в соответствии с календарем
        calendar.setTime(date);
        // задаем переменной номер недели, методом WEEK_OF_YEAR
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        // выводим номер недели на экран
        System.out.println("Номер недели: " + weekNumber);
    }
}