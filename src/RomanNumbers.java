import java.util.Map;
import java.util.TreeMap;

public class RomanNumbers {
    public static TreeMap<Integer, String> romanNumbers = new TreeMap<>();

    {
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
    }

    public static int convert(char romanNumber) {
        int converted = -1;
        for (Map.Entry<Integer, String> entry : romanNumbers.entrySet()) {
            if (entry.getValue().equals(String.valueOf(romanNumber))) return entry.getKey();
        }
        return converted;
    }

    public static int convertToArabicNumber(String romanNumber) {
        int converted = 0;
        char[] symbols = romanNumber.toCharArray();
        int i = 0;
        while (i < romanNumber.length()) {
            int number = convert(symbols[i]);
            if (number == -1) throw new ArithmeticException("В римской системе нет отрицательных чисел.");
            i++;
            if (i < symbols.length) {
                int nextNumber = convert(symbols[i]);
                if (nextNumber > number) {
                    converted += nextNumber - number;
                    i++;
                } else {
                    converted += number;
                }
            } else {
                converted += number;
            }
        }
        return converted;
    }

    public static String convertToRomanNumber(int arabicNumber) {
        if (arabicNumber < 0) throw new ArithmeticException("В римской системе нет отрицательных чисел.");
        int floor = romanNumbers.floorKey(arabicNumber);
        if (floor == arabicNumber) return romanNumbers.get(arabicNumber);
        return romanNumbers.get(floor) + convertToRomanNumber(arabicNumber - floor);
    }

    public static boolean isRomanNumber(String symbol) {
        return romanNumbers.containsValue(symbol);
    }
}
