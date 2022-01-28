package ru.edu.lesson1;

public class DigitConverterImpl implements DigitConverter {
    int digit, radix, precision;
    double doubleDigit;
    final String DIGITS = "0123456789ABCDEF";

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getRadix() {
        return radix;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public double getDoubleDigit() {
        return doubleDigit;
    }

    public void setDoubleDigit(double doubleDigit) {
        this.doubleDigit = doubleDigit;
    }

    @Override
    public String convert(int digit, int radix) {

        if (digit == 0) {
            return "0";
        }

        if (digit < 0) {
            return "Калькулятор не работает с отрицательными числами.";
        }

        if (radix < 2) {
            return "Не существует системы исчисления менее 2.";
        }

        if (radix > 16) {
            return "Калькулятор работает с системами исчисления от 2 до 16.";
        }

        String result = "";

        while (digit > 0) {
            int remainder = digit % radix;
            result = DIGITS.charAt(remainder) + result;
            digit = digit / radix;
        }
        
        return result;
    }

    @Override
    public String convert(double digit, int radix, int precision) {
        if (digit == 0) {
            return "0";
        }

        if (digit < 0) {
            return "Калькулятор не работает с отрицательными числами.";
        }

        if (radix < 2) {
            return "Не существует системы исчисления менее 2.";
        }

        if (radix > 16) {
            return "Калькулятор работает с системами исчисления от 2 до 16.";
        }

        if (precision < 1) {
            return "Число знаков после запятой должно быть больше 0.";
        }

        String digitChar = digit + "";

        int point = digitChar.lastIndexOf('.');
        int integer = Integer.parseInt(digitChar.substring(0, point));
        double fractionalPart = Double.parseDouble(digitChar.substring(point));

        String stringRight = convert(integer, radix);

        String stringLeft = "";

        for (int i = 0; i < precision; i++) {
            int multiplication = (int) (fractionalPart * radix);
            fractionalPart = fractionalPart * radix;

            if (multiplication > 0) {
                fractionalPart = fractionalPart - multiplication;
            }

            stringLeft = stringLeft + DIGITS.charAt(multiplication);
        }

        return stringRight + "." + stringLeft;
    }
}
