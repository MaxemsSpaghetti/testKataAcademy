import java.util.ArrayList;

public class Operators {
    public static ArrayList<String> operators = new ArrayList<>();

    {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public static int defineOperator(String scan) {
        int indexOfOperator = -1;
        for (int i = 0; i < operators.size(); i++) {
            if (scan.contains(operators.get(i))) {
                indexOfOperator = i;
            }
        }
        return indexOfOperator;
    }

    public static String getOperator(int indexOfOperator) {
        return (operators.get(indexOfOperator));
    }

    public static boolean isOperator(Character symbol) {
        return operators.contains(symbol.toString());
    }
}
