package lesson3;

import java.util.ArrayList;

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
        } else if (targetBox.getFruitList().isEmpty()) {
            targetBox.getFruitList().addAll(fruitList);
            fruitList.clear();
        } else {
            Class<? extends Fruit> currentFruitClass = fruitList.get(0).getClass();
            Class<? extends Fruit> targetFruitClass = targetBox.getFruitList().get(0).getClass();
            if (currentFruitClass == targetFruitClass) {
                targetBox.getFruitList().addAll(fruitList);
                fruitList.clear();
            } else {
                System.out.println("Can't pour over boxes of different fruit types");
            }
        }
    }

    public boolean compare(Box<T> box) {
       return box.getWeight() == this.getWeight();
    }

    @Override
    public String toString() {
        return "Size of fruit box = " + fruitList.size();
    }
}