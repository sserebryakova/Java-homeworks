package lesson3;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Apple> appleBox1 = new Box<>();
        System.out.println(appleBox);
        System.out.println(appleBox1);

        appleBox.pourOver(appleBox1);

        System.out.println(appleBox);
        System.out.println(appleBox1);

        appleBox.pourOver(appleBox1);

        appleBox.addFruit(new Apple());
        System.out.println(appleBox);
        System.out.println(appleBox1);

        appleBox.pourOver(appleBox1);
        System.out.println(appleBox);
        System.out.println(appleBox1);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox);
        System.out.println(appleBox1);

        appleBox.addFruit(new Apple());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
    }
}
