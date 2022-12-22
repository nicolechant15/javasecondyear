public class Equation {
    public static double equation(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23; // задаем и возвращаем функцию
    }

    public static double  solution(double start, double end){
        if(end - start <= 0.001){ // уточняем погрешность корня
            return start;
        }

        double x = (end + start) / 2; // используем метод половинного деления

        if(equation(start) * equation(x) > 0){ // смотрим, где лежит искомая точка
            return solution(x, end);
        }
        else {
            return solution(start, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 10)); // выводим значение искомой точки
    }
}