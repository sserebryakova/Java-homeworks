package homework6;

public class Cat extends Animal {
    public static int countCat = 0;
    private static String animalType = "Кот";
    private static float maxRun = 200;


    Cat(String name) {
        super(animalType, name, maxRun,0);
        ++countCat;
    }

    @Override
    public void swim(float distance) {
        System.out.println("Коты плавать не умеют");
    }
}
