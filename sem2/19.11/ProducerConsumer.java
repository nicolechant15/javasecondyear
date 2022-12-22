public class ProducerConsumer{
    public static void main(String[] args) {
        Main main = new Main(); // инциализируем класс
        Producer producer = new Producer(main);
        Consumer consumer = new Consumer(main);
        producer.start(); // начинаем выполнение потока
        consumer.start();
    }
}
class Main {
    private int contents; // будем записывать наше число
    private boolean available = false; // пуст буфер или нет, можно ли идти дальше

    public synchronized int get() {
        while (!available) { // пока идти нельзя ждем
            try {
                wait();
            } catch (InterruptedException e) { // ловим взаимоблокировку
                throw new RuntimeException(e);
            }
        }
        available = false;
        notifyAll(); // уведомляем ожидающий поток что теперь его очередь
        return contents; // берем значение

    }
    public synchronized void put(int num) {
        while (available) { // теперь можно идти
            try {
                wait();
            } catch (InterruptedException e) { // ловим взаимоблокировку
                throw new RuntimeException(e);
            }
        }
        contents = num; // задаем число
        available = true; // очередь свободна
        notifyAll(); // уведомляем
    }
}

class Producer extends Thread {
    private Main main1;
    public Producer(Main main) {
        main1 = main;
    }
    public void run() {
        for (int i = 1; i < 11; i++) { // задаем число
            main1.put(i);
            System.out.println("Произвели: " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {
    private Main main1;

    public Consumer(Main main) {
        main1 = main;
    }
    public void run() {
        for (int i = 1; i < 11; i++) { // берем число
            int num = main1.get();
            System.out.println("Потребили: " + num);
        }
    }
}
