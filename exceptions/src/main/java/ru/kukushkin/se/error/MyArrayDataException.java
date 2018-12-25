package ru.kukushkin.se.error;

public final class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message) {
        super("В ячейке " + message + " не число!");
    }
}
