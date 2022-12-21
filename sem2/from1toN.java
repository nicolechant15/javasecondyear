public class from1toN {
    public static void main(String[] args) {
        func(5); // берем функцию
    }

    public static int func(int num) {
        if (num == 1) { // если наше число равно 1 то просто его выводим
            System.out.print(num);
        }
        else { // в ином случае последовательно выводим числа, каждое из кот. меньше предыдщего на 1 в обр. порядке
            func(num - 1);
            System.out.print(" " + num);
        }
        return num;

    }
}
