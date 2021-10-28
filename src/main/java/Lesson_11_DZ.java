import array.ArraysMagic;
import fruit.Apple;
import fruit.Box;
import fruit.Orange;

/*
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Задача:
Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
- Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
  поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
- Для хранения фруктов внутри коробки можно использовать ArrayList;
- Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
  вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
- Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
  которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
  Можно сравнивать коробки с яблоками и апельсинами;
- Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
  Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
  Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
- Не забываем про метод добавления фрукта в коробку.
*/
public class Lesson_11_DZ {
    public static void main(String[] args) {
        //перемена местами двух указанных элементов массива любого типа
        ArraysMagic arrayOfString = new ArraysMagic("A", "S", "D");
        ArraysMagic arrayOfIntegers = new ArraysMagic(11, 22, 33);
        arrayOfString.changeElements(0, 2);
        arrayOfString.printArray();
        arrayOfIntegers.changeElements(1, 2);
        arrayOfIntegers.printArray();

        //ArrayList из массива
        arrayOfString.arrayToArrayList(arrayOfString.getArray());
        arrayOfString.printArrayList();

        //Apple and Orange
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Apple apple7 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();
        Orange orange6 = new Orange();
        Orange orange7 = new Orange();

        Box box1 = new Box(apple1, apple2, apple3);
        Box box2 = new Box(apple4, apple5);
        Box box3 = new Box(orange1, orange2, orange3);
        Box box4 = new Box(orange4, orange5);

        System.out.println("");
        System.out.println("Вес ящика box2 до: " + box2.getBoxWeight());
        box1.putFruitsToAnotherBox(box2);
        System.out.println("Вес ящика box2 после: " + box2.getBoxWeight());

        box3.addFruitsToBox(orange7);

        System.out.println("");
        System.out.println("Насыпаем разные фрукты в box1:");
        box1.addFruitsToBox(apple6, orange6, apple7); // проверка невозможности добавлять разные фрукты в один ящик

        System.out.println("");
        System.out.println("Сравнение веса box2 (c яблокми) и box4 (с апельсинами): " + box2.compare(box4));
    }
}
