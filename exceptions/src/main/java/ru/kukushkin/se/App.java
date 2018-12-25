package ru.kukushkin.se;

import ru.kukushkin.se.api.MyArray;
import ru.kukushkin.se.error.MyArrayDataException;
import ru.kukushkin.se.error.MyArraySizeException;

/**
 * @author Ilya Kukushkin
 * <p>
 * 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
 * и вывести результат расчета.
 */

public class App {
    public static void main(String[] args) {
        // Задаем размер массива. По условию размер должен быть 4х4.
        // В случае другого размера бросить MyArraySizeException.
        final int size_x = 4;
        final int size_y = 4;
        // Создаем двумерный массив
        final String[][] array = new String[size_x][size_y];
        // Заполняем массив случайными числами от 0 до 10.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ((Integer) ((int) (Math.random() * 10))).toString();
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        // Для проверки исключения MyArrayDataException записываем в ячейку символ.
        // array[1][3] = "aaa";
        // Проверка массива на соответсвие условию.
        try {
            System.out.println(MyArray.checkArraySize(array));
            System.out.println(MyArray.parseToIntAndSumUp(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
