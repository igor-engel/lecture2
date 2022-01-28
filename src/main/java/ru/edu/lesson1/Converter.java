package ru.edu.lesson1;

public class Converter {
    public static void main(String[] args) {
        DigitConverter converter = new DigitConverterImpl();
        System.out.println(converter.convert(125, 2));
        System.out.println(converter.convert(0.25, 2, 1));
    }
}
