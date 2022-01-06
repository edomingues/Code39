package com.edgardomingues.code39;

public class Code39 {

    public static void main(String... args) {
        String code = args[0].toUpperCase();
        System.out.println(code+calcCheckDigit(code));
    }

    static char calcCheckDigit(String code) {
        return intToChar(code.chars().mapToObj(Code39::charToInt).reduce(0, Integer::sum) % 43);
    }

    private static char intToChar(int i)
    {
        if (i >= 0 && i <= 9) {
            return Integer.toString(i).charAt(0);
        } else if (i < 36) {
            return (char) (i - 10 + 'A');
        } else {
            return switch (i) {
                case 36 -> '-';
                case 37 -> '.';
                case 38 -> ' ';
                case 39 -> '$';
                case 40 -> '/';
                case 41 -> '+';
                case 42 -> '%';
                default -> throw new IllegalArgumentException("Invalid number [%d]".formatted(i));
            };
        }
    }

    private  static int charToInt(int c) {
        if (c >= '0' && c <= '9') {
            return Integer.parseInt(String.valueOf((char) c));
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        } else {
            return switch (c) {
                case '-' -> 36;
                case '.' -> 37;
                case ' ' -> 38;
                case '$' -> 39;
                case '/' -> 40;
                case '+' -> 41;
                case '%' -> 42;
                default -> throw new IllegalArgumentException("Invalid char [%c]".formatted(c));
            };
        }
    }
}
