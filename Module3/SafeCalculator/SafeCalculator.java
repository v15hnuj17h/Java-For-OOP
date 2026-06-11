import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception
class InvalidOperatorException extends Exception {

    public InvalidOperatorException(String message) {
        super(message);
    }
}

public class SafeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            try {

                System.out.print("Enter first number (or type exit): ");
                if (sc.hasNext("exit")) {
                    System.out.println("Calculator closed.");
                    break;
                }

                double num1 = sc.nextDouble();

                System.out.print("Enter operator (+,-,*,/,%): ");
                char op = sc.next().charAt(0);

                if (op != '+' && op != '-' && op != '*' && op != '/' && op != '%') {
                    throw new InvalidOperatorException(
                        "Operator must be +, -, *, /, or %"
                    );
                }

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result = 0;

                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException(
                                "Cannot divide by zero"
                            );
                        }
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) {
                            throw new ArithmeticException(
                                "Cannot divide by zero"
                            );
                        }
                        result = num1 % num2;
                        break;
                }

                System.out.println("Result = " + result);
            }

            catch (InputMismatchException e) {
                System.out.println(
                    "Error: Please enter valid numbers."
                );
                sc.nextLine();
            }

            catch (InvalidOperatorException e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }

            catch (ArithmeticException e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }
            System.out.println();
        }

        sc.close();
    }
}