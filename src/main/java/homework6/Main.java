package homework6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Кузьма");
        cat.run(150);
        cat.run(250);
        cat.swim(10);
        Dog dog = new Dog("Бобик");
        dog.run(450);
        dog.run(550);
        dog.swim(5);
        dog.swim(15);

        System.out.println("Всего животных = " + Animal.countAnimal + "; котов = " + Cat.countCat + "; собак = " + Dog.countDog);
    }

}
