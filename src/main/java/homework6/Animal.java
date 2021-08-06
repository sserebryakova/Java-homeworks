package homework6;

public class Animal {
    private String animalType;
    private String animalName;
    private float maxRun;
    private float maxSwim;

    public static int countAnimal = 0;

    Animal(String type, String name, float maxRun, float maxSwim) {
        this.animalType = type;
        this.animalName = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        ++countAnimal;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void run(float distance) {
        if (distance <= maxRun) {
            System.out.println(animalType + " " + animalName + " пробежал " + distance + " метров");
        } else {
            System.out.println(animalType + " не может пробежать больше " + maxRun + " метров");
        }
    }

    public void swim(float distance) {
        if (distance <= maxSwim) {
            System.out.println(animalType + " " + animalName + " проплыл " + distance + " метров");
        } else {
            System.out.println(animalType + " не может проплыть больше " + maxSwim + " метров");
        }
    }
}


