package homework6;

public class Dog extends Animal {
    public static int countDog = 0;
    private static String animalType = "Пёс";
    private static float maxRun = 500;
    private static float maxSwim = 10;

    Dog(String name) {
        super(animalType, name, maxRun, maxSwim);
        ++countDog;
    }
}
