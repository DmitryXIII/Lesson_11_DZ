package fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private Class<? extends Fruit> boxType; //определение типа ящика (с яблоками или с апельсинами)
    private ArrayList<T> listOfFruits = new ArrayList<>();
    private float boxWeight;

    public Box(T... fruits) {
        T[] arrayOfFruis = fruits;
        for (int i = 0; i < arrayOfFruis.length; i++) {
            this.listOfFruits.add(arrayOfFruis[i]);
        }
        this.boxType = arrayOfFruis[0].getClass();
    }

    //определение вида содержимого ящика
    private void setBoxType() {
        this.boxType = null;
        if (this.listOfFruits.size() != 0) {
            this.boxType = this.listOfFruits.get(0).getClass();
        }
    }

    //подсчет веса содержимого ящика
    public float getBoxWeight() {
        this.boxWeight = 0;
        for (int i = 0; i < listOfFruits.size(); i++) {
            this.boxWeight += listOfFruits.get(i).getWeight();
        }
        return this.boxWeight;
    }

    //добавление фруктов в ящик
    public void addFruitsToBox(T... fruits) {
        T[] tempArray = fruits;
        for (int i = 1; i < tempArray.length; i++) {
            if (!tempArray[i].getClass().equals(tempArray[i - 1].getClass())) {
                System.out.println("Нельзя насыпать разные фрукты в одну корзину!");
                return;
            }
        }
        if (this.boxType == null) {
            for (int i = 0; i < tempArray.length; i++) {
                this.listOfFruits.add(tempArray[i]);
            }
            this.setBoxType();
        } else if (this.boxType.equals(tempArray[0].getClass())) {
            for (int i = 0; i < tempArray.length; i++) {
                this.listOfFruits.add(tempArray[i]);
            }
        } else {
            System.out.println("Нельзя насыпать разные фрукты в одну корзину!");
        }
    }

    //посмотреть содержимое ящика
    public void printBoxList() {
        if (this.listOfFruits.size() == 0) {
            System.out.println("Ящик пустой");
        }
        this.listOfFruits.forEach(System.out::println);
    }

    //пересыпание фруктов из одного ящика в другой
    public void putFruitsToAnotherBox(Box targetBox) {
        if (targetBox.boxType == null) {
            int x = this.listOfFruits.size();
            for (int i = 0; i < x; i++) {
                targetBox.addFruitsToBox(this.listOfFruits.get(listOfFruits.size() - 1));
                this.listOfFruits.remove(listOfFruits.size() - 1);
            }
            this.setBoxType();
            targetBox.setBoxType();
        } else if (this.boxType.equals(targetBox.boxType)) {
            int x = this.listOfFruits.size();
            for (int i = 0; i < x; i++) {
                targetBox.addFruitsToBox(this.listOfFruits.get(listOfFruits.size() - 1));
                this.listOfFruits.remove(listOfFruits.size() - 1);
            }
            this.setBoxType();
            targetBox.setBoxType();
        } else {
            System.out.println("Нельзя насыпать разные фрукты в одну корзину!");
        }
    }

    //сравнение веса ящиков
    public boolean compare(Box targetBox) {
        if (this.getBoxWeight() == targetBox.getBoxWeight()) {
            return true;
        } else {
            return false;
        }
    }
}
