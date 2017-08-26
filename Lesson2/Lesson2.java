import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите колическтво элементов массива: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        fillRandomNumbers(array);
        printArray(array);
        startTask(array);
    }

    // Заполнение массива рандомными цифрами от 0 до 10
    public static int[] fillRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

    // Вывод массива на консоль
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void startTask(int[] array) {
        System.out.println("Введите номер задания: ");
        Scanner sc = new Scanner(System.in);
        String taskNumber = sc.next();

        // Проверяем вводимый номер задания
        while (!taskNumber.equals("q")) {
            if (taskNumber.equals("1")) {
                sortDescending(array);
            } else if (taskNumber.equals("2")) {
                getMinAndMaxValues(array);
            } else if (taskNumber.equals("3")) {
                getTheMostOccurringNumber(array);
            } else {
                System.out.println("Задания " + taskNumber + " нет");
            }
            System.out.println("Введите номер следующего задания или q, чтобы выйти");
            taskNumber = sc.next();
        }
        System.out.println("Задание окончено");
    }

    // Сортировка по убыванию (задание 1)
    public static void sortDescending(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("Отсортированный массив - ");
        printArray(array);
    }

    // Поиск максимальных и минимальных элементов массива, вычисление их суммы (задание 2)
    public static void getMinAndMaxValues(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Min - " + min + ", max - " + max + ", Сумма - " + (min + max));
    }

    // Поиск самого(самых) повторяющегося элемента (задание 3)
    public static void getTheMostOccurringNumber(int[] array) {
        int maxCount = 1;
        int var = 0;
        int[] elements = new int[array.length]; // массив для хранения повторяющихся элементов
        int[] countArray = new int[array.length]; // массив для хранения кол-ва повторений

        for (int i = 0; i < elements.length; i++) {
            elements[i] = -1;
        }

        // Счетчик повторений
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    count++;
                }
            }
            if(count >= maxCount) {
                maxCount = count;
                elements[var] = array[i];
                countArray[var] = maxCount;
                var += 1;
            }
        }

        // Проверяем имеются ли элементы с одинаковыми значениями в массиве elements
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if((i != j) && (elements[i] == elements[j])) {
                    elements[j] = -1;
                    countArray[j] = 0;
                }
            }
        }

        // Поиск максимального количества повторений в countArray
        for (int i = 0; i < countArray.length; i++) {
            if(countArray[i] < maxCount) {
                elements[i] = -1;
            }
        }

        // Вывод на консоль
        for (int value : elements) {
            if(value > -1) {
                System.out.println("Самое повторяющееся число - " + value + ", повторилось " + maxCount + " раз");
            }
        }
    }
}
