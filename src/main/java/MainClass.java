
import java.util.Scanner;

public class MainClass {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        Expression expression = new Expression();
        expression.getExpression(expr);
        expression.print();
    }
}
