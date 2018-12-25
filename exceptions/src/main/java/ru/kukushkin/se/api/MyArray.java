package ru.kukushkin.se.api;

import ru.kukushkin.se.error.MyArrayDataException;
import ru.kukushkin.se.error.MyArraySizeException;

public final class MyArray {

    private MyArray() {
    }

    public static String checkArraySize(final String[][] array) throws MyArraySizeException {
        final String errorStr = "Размер массива не соответствует условию!";
        final String passStr = "Размер массива соответствует условию!";
        final int size_x = 4;
        final int size_y = 4;
        // Проверяем размер по x
        final boolean xMatchesTheCondition = array.length == size_x;
        // Проверяем размер всех вложенных массивов
        boolean yMatchesTheCondition = true;
        for (final String[] intArray : array) {
            yMatchesTheCondition &= intArray.length == size_y;
        }
        if (xMatchesTheCondition && yMatchesTheCondition) return passStr;
        else throw new MyArraySizeException(errorStr);
    }

    public static String parseToIntAndSumUp(final String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isParseToInt(array[i][j])) sum += Integer.parseInt(array[i][j]);
                if (!isParseToInt(array[i][j])) throw new MyArrayDataException("[" + i + "][" + j + "]");
            }
        }
        return "Сумма всех элементов массива равна " + sum;
    }

    private static boolean isParseToInt(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
