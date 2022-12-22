import java.util.Arrays;

public class Array {
    private static void perebor(int[] arr, int num) { // перебор

        String yesOrNo = "Нет";
        for (int i = 0; i < arr.length; i++) {  // перебираем каждый элемент массива и сравниваем его с заданным элементом
            if (arr[i] == num){
                yesOrNo = "Да"; // если элементы совпадают, то выводим Да
            }
        }

        System.out.println("Метод перебора:\nЧисло " + num + " есть в массиве? " + '\n' + yesOrNo + '\n'); // выводим ответ
    }

    public static String binarySearch(int[] arr, int first, int last, int num) {
        String yesOrNo = "Нет";
        if (last >= first){
            int middle = first + (last - first) / 2; // делим по половинкам пока не найдем искомое число
            if (arr[middle] == num) {
                yesOrNo = "Да";
            } 
            else if (arr[middle] > num) {
                return binarySearch(arr, first, middle - 1, num);
            } 
            else if (arr[middle] < num) {
                return binarySearch(arr, middle + 1, last, num);
            }
        }
        System.out.println("Бинарный поиск:\nЧисло " + num + " есть в массиве? " + '\n' + yesOrNo); // выводим ответ

        return yesOrNo;
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 1, 9, 7, 2, 6, 10}; // объявляем массив
        Arrays.sort(arr); // сортируем массив
        int num = 7; // задаем элемент
        int first = arr[0]; // берем первый элемент
        int last = arr[arr.length-1]; //берем последний элемент

        System.out.println("Массив: " + java.util.Arrays.toString(arr) + '\n'); // выводим массив

        perebor(arr, num); // берем функцию
        binarySearch(arr, first, last, num); // берем функцию
    }
}
