package lesson3;

import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList = new ArrayList<>();

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float getWeight() {
        return fruitList.size() * fruitList.get(0).getWeight();
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }

    public void pourOver(Box<T> targetBox) {
        if (fruitList.isEmpty()) {
            System.out.println("Current box is empty");
        } else {
            targetBox.getFruitList().addAll(fruitList);
            fruitList.clear();
        }
    }

    public boolean compare(Box<?> box) {
        return box.getWeight() == this.getWeight();
    }

    @Override
    public String toString() {
        return "Size of fruit box = " + fruitList.size();
    }
}