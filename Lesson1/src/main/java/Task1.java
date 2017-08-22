import java.util.Scanner;

// Задание первое - решение уравнения

public class Task1 {
    public static void main(String[] args) {
        // Считываем с консоли x и y
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the x:");
        int x = sc.nextInt();
        System.out.println("Enter the y:");
        int y = sc.nextInt();

        System.out.println("The answer is: " + calculateEquation(x , y));
    }

    // Вычисление уравнения
    public static double calculateEquation(int x, int y) {
        return (double) (3 * (x + 2 * x - y)) / (2 * x);
    }
}
