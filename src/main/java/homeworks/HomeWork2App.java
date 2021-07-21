package homeworks;

public class HomeWork2App {
    public static void main(String[] args) {
        boolean task1 = checkSum(5, 6);
        System.out.println(task1);
        System.out.println();

        isPositive(5);
        System.out.println();

        boolean task3 = checkNegative(-5);
        System.out.println(task3);
        System.out.println();

        printString("Hello", 5);
        System.out.println();
    }

    public static boolean checkSum(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean checkNegative(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printString(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s) ;
        }
    }
}
