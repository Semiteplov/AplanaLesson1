public class Main {
    public static void main(String[] args) {

        // Создаем экзмепляры классов сладостей
        Sweet chocolate = new Chocolate("Dark chocolate", 15.2, 12, 60);
        Sweet cookie = new Cookie("Oat flour cookies", 5.8, 4, "Round");
        Sweet marshmallow = new Marshmallow("Fluffy marshmallow", 2.3, 5.4, "Purple");

        // Создаем экземпляр класса подарка
        Gift g = new Gift(chocolate, cookie, marshmallow);

        // Выводим на экран информацию о подарке
        g.printSweetsInfo();

        // Считаем и выводим на экран общий вес и общую стоимость подарка
        g.calculateTotalWeight();
        System.out.println("Total weight is - " + g.getTotalWeight());
        g.calculateTotalPrice();
        System.out.println("Total price is - " + g.getTotalPrice());

    }
}
