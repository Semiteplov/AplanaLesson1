import java.util.Scanner;

// Задание второе - обработка строки

public class Task2 {
    public static void main(String[] args) {
        // Считываем с консоли исходную строку
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String string = sc.nextLine();

        replaceWord(string);
        newString(string);

    }

    // Замена слова в исходной строке
    public static void replaceWord(String string) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the replaceable word:");
        String replaceableWord = sc.nextLine();
        System.out.println("Enter the new word:");
        String newWord = sc.nextLine();
        System.out.println("New string is: " + string.replace(replaceableWord, newWord));
    }

    // Получение подстроки исходной строки 
    public static void newString(String string) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the beginIndex:");
        int begIndex = sc.nextInt();
        System.out.println("Enter the endIndex:");
        int endIndex = sc.nextInt();
        System.out.println("New string is: " + string.substring(begIndex, endIndex));
    }
}
