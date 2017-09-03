import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Создаем игроков
        Player pl1 = new Player("Mike", 67);
        Player pl2 = new Player("Bob", 49);
        Player pl3 = new Player("Jason", 54);
        Player pl4 = new Player("George" , 50);
        Player pl5 = new Player("Johnson", 38);

        // Создаем Map с парами Игрок-Очки
        HashMap<String, Integer> map = createMap(pl1, pl2, pl3, pl4, pl5);

        // Создаем остортированную Map
        Map<String, Integer> sortedMap = sortByValue(map);

        System.out.println("Отсортированный список очков:");
        printScoreList(sortedMap);

        System.out.println("Отсортированный список игроков с очками:");
        printSortedMap(sortedMap);

        System.out.println("Топ-3 игрока:");
        printTopThreePlayers(sortedMap);
    }

    // Метод, формирующий Map из игроков
    public static HashMap<String, Integer> createMap(Player... players) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i].getName(), players[i].getScore());
        }
        return map;
    }

    // Метод, сортирующий значения по убыванию
    public static <String, Integer extends Comparable<Integer>> Map<String, Integer> sortByValue(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<String, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    // Вывод на экран пар ключ-значений по убыванию значений
    public static void printSortedMap(Map<String, Integer> map) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("-------------------------------------------");
    }

    // Вывод на экран списка очков
    public static void printScoreList(Map<String, Integer> map) {
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getValue());
        }
        System.out.println("-------------------------------------------");
    }

    // Вывод на экран топ-3 игрока
    public static void printTopThreePlayers(Map<String, Integer> map) {
        int i = 0;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            while(i < 3) {
                Map.Entry entry = (Map.Entry) it.next();
                System.out.println(entry.getKey());
                i++;
            }
            break;
        }
        System.out.println("-------------------------------------------");
    }
}
