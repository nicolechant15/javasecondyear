import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

public class millionelements {
    public static void main(String[] args) {
        ArrayList<Double> array = new ArrayList<>();
        LinkedList<Double> linked = new LinkedList<>();
        int elements = 1000000;
        Instant startfor1000000 = Instant.now();
        for (int i = 0; i < elements; i++){
            array.add(Math.random());
            linked.add(Math.random());
        }
        Instant endfor1000000 = Instant.now();
        long timespentfor1000000 = Duration.between(startfor1000000, endfor1000000).toMillis();
        System.out.println("Затрачено времени на добавление 1000000 элементов: " + timespentfor1000000 + " " + "миллисекунд");

        int numberoftimes = 100000;
        Instant startfor100000 = Instant.now();
        for (int i = 0; i < numberoftimes; i++) {
            array.get((int) (Math.random() * numberoftimes));
        }
        Instant endfor100000 = Instant.now();
        long timespentfor100000 = Duration.between(startfor100000, endfor100000).toMillis();
        System.out.println("Затрачено времени на выборку элемента 100000 раз: " + timespentfor100000 + " " + "миллисекунд");

        if (timespentfor100000 > timespentfor1000000){
            System.out.println("Добавление элементов было быстрее выборки");
        }
        else if (timespentfor100000 < timespentfor1000000) {
            System.out.println("Выборка была быстрее добавления элементов");
        }
        else {
            System.out.println("Время добавления элементов и выборки равно");
        }
    }
}
