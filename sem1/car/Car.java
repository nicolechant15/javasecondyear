public class Car {
    String color;
    int max_speed;
    String gearbox_type;
    int current_speed;
    int price;

    Car(String color, int max_speed, String gearbox_type, int current_speed, int price){
        this.color = color;
        this.max_speed = max_speed;
        this.gearbox_type = gearbox_type;
        this.current_speed = current_speed;
        this.price = price;
    }

    void start(String start){
        switch (start){
            case ("Да"):
                System.out.println("Машина начала двигаться");
                break;
            case ("Нет"):
                System.out.println("Машина не начала двигаться");
                break;
        }
    }

    void stop(String stop){
        switch (stop){
            case ("Да"):
                System.out.println("Машина остановилась");
                break;
            case ("Нет"):
                System.out.println("Машина не остановилась");
                break;
        }
    }

    void accelerate(int add_speed){
        int new_speed = 0;
        new_speed = current_speed + add_speed;
        System.out.println("Новая скорость: " + new_speed);
    }
}

class Nissan extends Car{

    Nissan(String color, int max_speed, String gearbox_type, int current_speed, int price){
        super(color, max_speed, gearbox_type, current_speed, price);
    }

    void beep(){
        System.out.println("Бип");
    }

}

class Honda extends Car{

    Honda(String color, int max_speed, String gearbox_type, int current_speed, int price, int amount_of_doors){
        super(color, max_speed, gearbox_type, current_speed, price);
    }
}

