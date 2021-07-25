package homeworks;

public class HomeWork2App {
    public static void main(String[] args) {
        System.out.println(checkSum(5, 6));

        isPositive(5);

        System.out.println(checkNegative(-5));

        printString("Hello", 5);
    }

    public static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNegative(int a) {
        return a < 0;
    }

    public static void printString(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s) ;
        }
    }
}
