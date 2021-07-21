package homeworks;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println();
        checkSumSign();
        System.out.println();
        printColor();
        System.out.println();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }


    public static void checkSumSign() {
        int a = 10;
        int b = -15;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        String answer = a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(answer);
    }

    public static void printColor() {
        int value = -1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 3;
        int b = 6;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
