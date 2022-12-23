import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Task{
    // объявляем переменные
    int id;
    String createDate;
    String deadline;
    String isFinished;
    String name;
    String description;
    static ArrayList<Task> toDoList = new ArrayList<>() {}; // объявляем основной динамический массив, где будут хранится созданные задания
    public Task(String deadline, String name, String description){ // конструктор задания
        this.id = (int)(Math.random()*10000000); // ид - рандомное число в пределах 10000000
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)); // дата создания -
        // - сейчас в формате ДД.ММ.ГГГГ
        this.deadline = deadline; // дедлайн
        this.isFinished = "Не выполнено"; // выполнено задание или нет. По умолчанию не выполнено
        this.name = name; // название задания
        this.description = description; // детальное описание задания
    }

    // объявляем геттеры чтобы можно было обращаться к элементам
    public int getId() {
        return id;
    }

    public String getCreateDate(){
         return createDate;
    }

    public String getDeadline(){
         return deadline;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // объявляем сеттеры чтобы можно было задавать новые значения
    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public void setIsFinished(String isFinished){
        this.isFinished = isFinished;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public static void create(){ // метод создания задания
        while (true){ // будет запускаться, пока не будут введены правильные значения
            try{
                System.out.println("Введите название задания: "); // с клавиатуры вводим название задания
                Scanner name1 = new Scanner(System.in);
                String name = name1.nextLine();

                System.out.println("Введите описание: "); // с клавиатуры вводим описание
                Scanner desc = new Scanner(System.in);
                String description = desc.nextLine();

                System.out.println("Введите дедлайн в формате ДД.ММ.ГГГГ: "); // дедлайн
                Scanner deadline1 = new Scanner(System.in);
                String deadline = deadline1.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy"); // задаем формат
                LocalDate deadline2 = LocalDate.parse(deadline, formatter); // приводим к заданному формату и обращаем в локалдейт,
                // чтобы потом воспользоваться его методами

                LocalDate createDate = LocalDate.now(); // берем дату сейчас

                if(deadline2.isAfter(createDate) || deadline2.isEqual(createDate)){ // сравниваем дату дедлайна с датой сейчас
                    // если она не меньше, то создаем задание
                    Task task = new Task(deadline, name, description); // инициализируем класс и задаем ему введеные с клавиатуры параметры
                    toDoList.add(task); // добавляем задание в дин. массив

                    System.out.println("Создано задание:\n");
                    System.out.println("Название: " + name + '\n' + "Описание: " + description + '\n' + "Дедлайн: "
                    + deadline);
                }
                else{
                    System.out.println("Нельзя установить дату дедлайна меньше текущей"); // стр.92 - иначе ошибка
                }
                break;

            }
            catch(Exception e){ // если что-то было не так, выводим ошибку
                System.out.println("Что-то Вы напортачили");
            }

        }
    }

    public static Task findById() { // метод поиска задания по ид
        showAll(); // сначала выводим все задания, чтобы можно было посмотреть номер задания и ввести
        Task desiredTask; // объявляем переменную, которая будет выводить необходимое задание
        while (true) { // пока не введем правильно задание цикл будет запускаться
            try {
                System.out.println("Введите номер задания: "); // берем с клавиатуры ид задания
                Scanner id1 = new Scanner(System.in);
                String id = id1.nextLine();

                desiredTask = null; // пока необходимого задания нет
                for (Task task: toDoList) { // циклом проходимся по основному дин. массиву
                    if ((task.getId()) == Integer.parseInt(id)) { // если находим задание, ид которого совпадает с искомым
                        desiredTask = task; // то передаем ему значение
                    }
                }
                break;

            } catch (Exception e) { // ловим ошибку
                System.out.println("Такого задания не существует");
            }
        }
        return desiredTask; // возвращаем искомое задание, чтобы в других методах с ним работать
    }

    public static void delete(){ // метод удаления
        toDoList.remove(findById()); // берем задание из прошлого метода и удаляем его из дин. массива
        System.out.println("Задание удалено");
    }

    public static void edit(){ // метод редактирования
            try {
                Task task = findById(); // задаем таску значение возвращенного задания из метода findById()

                System.out.println(""" 
                        Что вы хотите поменять?\s
                        1 - Название
                        2 - Описание
                        3 - Дедлайн
                        4 - Статус выполнения""");

                Scanner toChange1 = new Scanner(System.in); // берем с клавиатуры команду
                String toChange = toChange1.nextLine();

                switch (toChange) {
                    case ("1"): // если 1 то меняем название
                        System.out.println("Новое название: ");
                        Scanner newName1 = new Scanner(System.in); // берем новое название
                        String newName = newName1.nextLine();
                        task.setName(newName); // и через сеттер меняем
                        System.out.println("Задание изменено");
                        break;
                    case ("2"): // если 2 то меняем описание
                        System.out.println("Новое описание: ");
                        Scanner newDescr1 = new Scanner(System.in); // берем новое
                        String newDescr = newDescr1.nextLine();
                        task.setDescription(newDescr); // через сеттер меняем
                        System.out.println("Задание изменено");
                        break;
                    case ("3"): // если 3 то меняем дедлайн
                        System.out.println("Новый дедлайн в формате ДД.ММ.ГГГГ: ");
                        Scanner newDeadline1 = new Scanner(System.in); // берем новый
                        String newDeadline = newDeadline1.nextLine();
                        task.setDeadline(newDeadline); // через сеттер задаем новый
                        // не стала проверять, раньше или позже дедлайн той даты, которая
                        // сейчас, потому что у меня было такое, что меняла на заднее число
                        System.out.println("Задание изменено");
                        break;
                    case ("4"): // если 4 то спрашиваем выполнено или нет
                        System.out.println("Вы выполнили задание? Если да - 1, если нет - 0");
                        Scanner newIsFinished2 = new Scanner(System.in); // берем команду
                        String newIsFinished1 = newIsFinished2.nextLine();

                        try {
                            switch (newIsFinished1) {
                                case ("1"): // если 1, то устанавливаем, что задание выполнено
                                    task.setIsFinished("Выполнено");
                                    System.out.println("Задание изменено");
                                    break;
                                case ("0"): // если 0, то не выполнено (это на случай если, например, случайно поставили, что выполнено
                                    task.setIsFinished("Не выполнено");
                                    System.out.println("Задание изменено");
                                    break;

                            }
                        } catch (Exception e) { // ловим ошибку на неверную команду
                            System.out.println("Вы ввели неверную команду");
                        }


                }
            } catch (Exception e) { // и здесь тоже
                System.out.println("Вы ввели неверную команду");
            }
}

    public static void showAll(){ // метод, кот. показыват все задания
//        for(int i = 0; i < toDoList.size(); i++) { // проходимся по массиву
            for (Task task : toDoList) { // по каждому заданию
                // берем некоторые параметры задания
                // у нас есть вывод детальной информации, а есть не детальной, не поняла, что конкретно в случае
                // не детальной выводить, поэтому как есть
                int id = task.getId();
                String deadline = task.getDeadline();
                String name = task.getName();
                String isFinished = task.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Статус выполнения: "
                        + isFinished + '\n');
            }
//        }
    }

    public static void showIsFinished(){ // метод выводящий все законченные задания
        Task desiredTask;
        for (Task task: toDoList) { // проходимся по заданиям
            if (Objects.equals(task.getIsFinished(), "Выполнено")) { // берем значение isFinished: если равно "Выполнено"
                desiredTask = task; // то приваем задание
                // берем параметры и выводим
                int id = desiredTask.getId();
                String createDate = desiredTask.getCreateDate();
                String deadline = desiredTask.getDeadline();
                String name = desiredTask.getName();
                String description = desiredTask.getDescription();
                String isFinished = desiredTask.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
        }

    }

    public static void showIsNotFinished(){ // выводит незаконченные задания
        Task desiredTask;
        for (Task task: toDoList) { // здесь все то же самое короче
            if (Objects.equals(task.getIsFinished(), "Не выполнено")) {
                desiredTask = task;
                int id = desiredTask.getId();
                String createDate = desiredTask.getCreateDate();
                String deadline = desiredTask.getDeadline();
                String name = desiredTask.getName();
                String description = desiredTask.getDescription();
                String isFinished = desiredTask.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
        }

    }

    public static ArrayList<Task> findAllByDeadline() { // ищет все задания по значению дедлайна
        ArrayList<Task> desiredTask = new ArrayList<>(); // создаю новый массив, чтобы закидывать сюда задания
        // с указанным дедлайном
        while (true) {
            try {
                System.out.println("Введите дату выполнения задания в формате ДД.ММ.ГГГГ: ");
                Scanner deadline2 = new Scanner(System.in); // берем дату выполнения
                String deadline1 = deadline2.nextLine();

                for (Task task: toDoList) { // проходимся по заданию
                    if (Objects.equals(task.getDeadline(), deadline1)) { // если у задания такая же дата
                        desiredTask.add(task); // то добавляем его в новый массив
                    }
                }
                break;
            } catch (Exception e) { // ловим ошибку
                System.out.println("Задания с такой датой не существует");

            }
        }
        return desiredTask; // возвращаем этот массив, чтобы в других методах с ним рабоать
    }
    public static void showAllOnDeadline(){ // показывает все задания с заданным дедлайном
        ArrayList<Task> task = findAllByDeadline(); // берем массив из прошлого метода
        for(Task t: task){ // проходимся по нему и берем значения параметров, выводим на экран
            int id = t.getId();
            String createDate = t.getCreateDate();
            String deadline = t.getDeadline();
            String name = t.getName();
            String description = t.getDescription();
            String isFinished = t.getIsFinished();

            System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                    "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                    description + '\n' + "Статус выполнения: " + isFinished + '\n');
        }
    }

    public static void showIsFinishedOnDeadline(){ // выводит выполненные задания с заданным дедлайном
        ArrayList<Task> allTasksByDeadline = findAllByDeadline(); // берем массив из метода findAllByDeadline()
        for (Task t: allTasksByDeadline) { // прохдимся по нему
            if (Objects.equals(t.getIsFinished(), "Выполнено")) { // смотрим, что лежит в перменной isFinished
                allTasksByDeadline.add(t); // если "Выполнено", то добавляем задание в массив
                // берем параметры задания и выводим все на экран
                int id = t.getId();
                String createDate = t.getCreateDate();
                String deadline = t.getDeadline();
                String name = t.getName();
                String description = t.getDescription();
                String isFinished = t.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
            break;
        }
    }

    public static void showIsNotFinishedOnDeadline(){ // выводит невыполненные задания с заданным дедлайном
        ArrayList<Task> allTasksByDeadline = findAllByDeadline();
        for (Task t: allTasksByDeadline) { // все аналогично, писать не буду, только сравнивает с "Не выполнено"
            if (Objects.equals(t.getIsFinished(), "Не выполнено")) {
                allTasksByDeadline.add(t);
                int id = t.getId();
                String createDate = t.getCreateDate();
                String deadline = t.getDeadline();
                String name = t.getName();
                String description = t.getDescription();
                String isFinished = t.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
            break;
        }
    }

    public static ArrayList<Task> findAllByCreateDate() { // находит все задания с заданной датой создания
        ArrayList<Task> desiredTask = new ArrayList<>(); // создаем дин. массив чтобы закидвать туда искомые задания
        while (true) {
            try {
                System.out.println("Введите дату создания задания в формате ДД.ММ.ГГГГ: ");
                Scanner createDate2 = new Scanner(System.in); // берем с клавиатуры дату создания
                String createDate1 = createDate2.nextLine();

                for (Task task: toDoList) { // проходимся по основному массиву
                    if (Objects.equals(task.getCreateDate(), createDate1)) { // если у задания дата создания совпадает с введенной
                        desiredTask.add(task); // добавляем его в новый массив
                    }
                }
                break;
            } catch (Exception e) { // ловим ошибку
                System.out.println("Задания с такой датой не существует");

            }
        }
        return desiredTask; // возвращаем массив, чтобы потом использовать его в др. методах
    }
    public static void showAllOnCreateDate(){ // выводит все задания с заданной датой создания
        ArrayList<Task> task = findAllByCreateDate(); // берем массив из прошлого метода
        for(Task t: task){ // проходимся по нему, берем параметры и выводим на экран
            int id = t.getId();
            String createDate = t.getCreateDate();
            String deadline = t.getDeadline();
            String name = t.getName();
            String description = t.getDescription();
            String isFinished = t.getIsFinished();

            System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                    "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                    description + '\n' + "Статус выполнения: " + isFinished + '\n');
        }
    }

    public static void showIsFinishedOnCreateDate(){ // выводит законченные задания с заданной датой создания
        ArrayList<Task> allTasksByCreateDate = findAllByCreateDate(); // берем массив из findAllByCreateDate()
        for (Task t: allTasksByCreateDate) { // проходимся по массиву
            if (Objects.equals(t.getIsFinished(), "Выполнено")) { // если значение isFinished равно "Выполнено"
                allTasksByCreateDate.add(t); // добавляем в массив, берем параметры и выводим на экран
                int id = t.getId();
                String createDate = t.getCreateDate();
                String deadline = t.getDeadline();
                String name = t.getName();
                String description = t.getDescription();
                String isFinished = t.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
            break;
        }
    }

    public static void showIsNotFinishedOnCreateDate(){ // выводит законченные задания с заданной датой создания
        ArrayList<Task> allTasksByDeadline = findAllByDeadline(); // делаем все то же самое, только сравниваем с "Не выполнено"
        for (Task t: allTasksByDeadline) {
            if (Objects.equals(t.getIsFinished(), "Не выполнено")) {
                allTasksByDeadline.add(t);
                int id = t.getId();
                String createDate = t.getCreateDate();
                String deadline = t.getDeadline();
                String name = t.getName();
                String description = t.getDescription();
                String isFinished = t.getIsFinished();

                System.out.println("Номер задания: " + id + '\n' + "Дата создания: " + createDate + '\n' +
                        "Дата выполнения: " + deadline + '\n' + "Наименование: " + name + '\n' + "Детальное описание: " +
                        description + '\n' + "Статус выполнения: " + isFinished + '\n');
            }
            break;
        }
    }


    public static void showDetailed(){ // выводит детальную информацию о задании
        Task t = findById(); // по номеру находим задания через метод findById() и передаем в t
        // берем все существующие параметры и выводим на экран
        int id = t.getId();
        String createDate = t.getCreateDate();
        String deadline = t.getDeadline();
        String name = t.getName();
        String description = t.getDescription();
        String isFinished = t.getIsFinished();

                System.out.println("Номер задания: " + id + "\n" + "Дата создания: " + createDate + "\n" +
                        "Дата выполнения: " + deadline + "\n" + "Наименование: " + name + "\n" + "Детальное описание: " +
                        description + "\n" + "Статус выполнения: " + isFinished);
    }


    public static void run(){ // выполняет все методы в зависимости от выбранных команд
        System.out.println("""
                Команды:\s
                1 - Создать задание
                2 - Удалить задание
                3 - Отредактировать задание
                4 - Посмотреть список всех заданий
                5 - Посмотреть список выполненных заданий
                6 - Посмотреть список невыполненных заданий
                7 - Посмотреть список всех заданий на конкретную дату выполнения
                8 - Посмотреть список выполненных заданий на конкретную дату выполнения
                9 - Посмотреть список невыполненных заданий на конкретную дату выполнения
                10 - Посмотреть список всех заданий на конкретную дату создания
                11 - Посмотреть список выполненных заданий на конкретную дату создания
                12 - Посмотреть список невыполненных заданий на конкретную дату создания
                13 - Посмотреть детальную информацию о задании
                """);
        //
        while (true){ // пока не введется правильная команда будет работать
            try {
                System.out.println("\nВведите команду: ");
                Scanner comm = new Scanner(System.in); // берем с клавиатуры команду
                String command = comm.nextLine();
                switch (command){ // в зависимости от того, что ввели, обращаемся к методам
                    case("1"):
                        create();
                        break;
                    case("2"):
                        delete();
                        break;
                    case("3"):
                        edit();
                        break;
                    case("4"):
                        showAll();
                        break;
                    case("5"):
                        showIsFinished();
                        break;
                    case("6"):
                        showIsNotFinished();
                        break;
                    case("7"):
                        showAllOnDeadline();
                        break;
                    case("8"):
                        showIsFinishedOnDeadline();
                        break;
                    case("9"):
                        showIsNotFinishedOnDeadline();
                        break;
                    case("10"):
                        showAllOnCreateDate();
                        break;
                    case("11"):
                        showIsFinishedOnCreateDate();
                        break;
                    case("12"):
                        showIsNotFinishedOnCreateDate();
                        break;
                    case("13"):
                        showDetailed();
                        break;
                }
            }
            catch(Exception e){ // ловим ошибку
                System.out.println("Вы ввели неверную команду. Попробуйте еще раз: \n");
            }
        }
    }

    public static void main(String[] args){ // основной метод, берет тот, что выполняет все команды
        run();
    }
}
