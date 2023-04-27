import java.util.ArrayList;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        startAction();
        try (Scanner scanner = new Scanner(System.in)) {
            String scan = scanner.nextLine();
            System.out.println(calc(scan));
        } catch (Exception e) {
            throw new NullPointerException("упс...попробуйте что-нибудь написать.");
        }
    }

    public static String calc(String input) throws Exception {
        new RomanNumbers();
        new Operators();

        input = input.replace(" ", "");
        int indexOfOperator = Operators.defineOperator(input);
        if (indexOfOperator == -1) {
            throw new ArithmeticException("Cтрока не является математической операцией.");
        }
        String operator = Operators.getOperator(indexOfOperator);

        char[] symbols = input.toCharArray();


        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> operands = new ArrayList<>();
        DigitType digitType1 = new DigitType();
        DigitType digitType2 = new DigitType();
        int count = 0;

        for (int i = 0; i < symbols.length; i++) {
            if (Operators.isOperator(symbols[i])) {
                if (count > 0) {
                    int b = RomanNumbers.convertToArabicNumber(stringBuilder.toString());
                    if (b < 1 || b > 10) throw new ArithmeticException("Допустимые значения для числа от 1 до 10.");
                    operands.add(RomanNumbers.convertToArabicNumber(stringBuilder.toString()));
                    stringBuilder.setLength(0);
                    digitType1.setType(Type.ROMAN);
                } else {
                    int a = Integer.parseInt(stringBuilder.toString());
                    if (a < 1 || a > 10) throw new ArithmeticException("Допустимые значения для числа от 1 до 10.");
                    operands.add(Integer.parseInt(stringBuilder.toString()));
                    stringBuilder.setLength(0);
                    digitType1.setType(Type.ARABIC);
                }
            } else {
                if (RomanNumbers.isRomanNumber(Character.toString(symbols[i]))) {
                    stringBuilder.append(symbols[i]);
                    count++;
                    if (i == symbols.length - 1) {
                        int b = RomanNumbers.convertToArabicNumber(stringBuilder.toString());
                        if (b < 1 || b > 10) throw new ArithmeticException("Допустимые значения для числа от 1 до 10.");
                        operands.add(RomanNumbers.convertToArabicNumber(stringBuilder.toString()));
                        stringBuilder.setLength(0);
                        digitType2.setType(Type.ROMAN);
                    }
                } else {
                    stringBuilder.append(Integer.parseInt(String.valueOf(symbols[i])));
                    if (i == symbols.length - 1) {
                        int a = Integer.parseInt(stringBuilder.toString());
                        if (a < 1 || a > 10) throw new ArithmeticException("Допустимые значения для числа от 1 до 10.");
                        operands.add(Integer.parseInt(stringBuilder.toString()));
                        stringBuilder.setLength(0);
                        digitType2.setType(Type.ARABIC);
                    }
                }
            }
        }
        if (!digitType1.getType().equals(digitType2.getType()))
            throw new Exception("Используются одновременно разные системы счисления.");
        String result = Calculator.calculate(operands.get(0), operands.get(1), operator, digitType1);

        return result;
    }

    public static void startAction() {
        System.out.println("Добро пожаловать в мой простенький калькулятор.");
        System.out.println("В нем можно использовать арабские и римские цифры от 1 до 10,");
        System.out.println("А также операции: Сложения(+), Вычитания(-), Умножения(*) и Деления(/).");
        System.out.println();
        System.out.println("P.S. Под капот лучше не заглядывать, тут страшно))))");
        System.out.println();
        System.out.println("Введите выражение:");
    }
}



