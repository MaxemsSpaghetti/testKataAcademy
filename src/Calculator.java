public class Calculator {
    public static String calculate(int number1, int number2, String operator, DigitType digit) {
        int result;
        switch (operator) {
            case ("+") -> result = number1 + number2;
            case ("-") -> result = number1 - number2;
            case ("*") -> result = number1 * number2;
            case ("/") -> result = number1 / number2;
            default -> throw new ArithmeticException("упс(( такого оператора нет(");
        }
        if (digit.getType() == Type.ROMAN) {
            return RomanNumbers.convertToRomanNumber(result);
        } else {
            return Integer.toString(result);
        }
    }
}
