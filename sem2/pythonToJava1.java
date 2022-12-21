import java.util.Scanner;

public class pythonToJava1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // c клавиатуры вводим значение
        System.out.print("Введите число: ");
        int num1 = in.nextInt(); // присваем его переменной num1
        in.close(); // закрываем сканер

        func(num1); // берем функцию
    }

    public static int func(int num) { // функция аналогичная функции на питоне
        if (num == 1) {
            System.out.println(num);
        }
        else {
            System.out.print(num + " ");
            func(num - 1);
        }
        return num;

    }
}