
import java.util.*;

public class Cal {

    public static void showMenu() {

        System.out.println("\n===== CALCULATOR =====");
        System.out.println("1. Calculate");
        System.out.println("2. History");
        System.out.println("3. Clear History");
        System.out.println("4. Exit");
    }

    public static double performOperation(
            Calculator calculator,
            double num1,
            String operator,
            double num2) {

        switch (operator) {

            case "+":
                return calculator.add(num1, num2);

            case "-":
                return calculator.subtract(num1, num2);

            case "*":
                return calculator.multiply(num1, num2);

            case "/":
                return calculator.divide(num1, num2);

            case "%":
                return calculator.modulus(num1, num2);

            case "^":
                return calculator.power(num1, num2);

            case "sqrt":
                return calculator.squareRoot(num1);

            default:
                throw new IllegalArgumentException(
                    "Invalid operator: " + operator
                );
        }
    }

    public static void showHistory(ArrayList<String> history) {

        if (history.isEmpty()) {
            System.out.println("No calculation history.");
        } else {
            System.out.println("\n===== HISTORY =====");

            for (String calculation : history) {
                System.out.println(calculation);
            }
        }
    }

    public static void clearHistory(ArrayList<String> history) {

        if (history.isEmpty()) {
            System.out.println("Calculator History Is Already Clear");
        } else {
            history.clear();
            System.out.println("History Cleared Successfully");
        }
    }

    public static double getNumber(
            Scanner sc,
            String message) {

        while (true) {

            try {
                System.out.print(message);
                return sc.nextDouble();

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Please enter a valid number."
                );

                sc.nextLine();
            }
        }
    }

    public static String getOperator(Scanner sc) {

        while (true) {

            System.out.print(
                "Enter operator (+, -, *, /, %, ^, sqrt): "
            );

            String operator = sc.next();

            switch (operator) {

                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                case "sqrt":
                    return operator;

                default:
                    System.out.println(
                        "Invalid Choice! Please select +, -, *, /, %, ^ or sqrt."
                    );
            }
        }
    }

    public static void performCalculation(
            Calculator calculator,
            Scanner sc,
            ArrayList<String> history) {

        try {

            double num1 = getNumber(
                sc,
                "Enter first number: "
            );

            String operator = getOperator(sc);

            double num2 = 0;

            if (!operator.equals("sqrt")) {
                num2 = getNumber(
                    sc,
                    "Enter second number: "
                );
            }

            double result = performOperation(
                calculator,
                num1,
                operator,
                num2
            );

            System.out.println("Result = " + result);

            if (operator.equals("sqrt")) {

                history.add(
                    "sqrt(" + num1 + ") = " + result
                );

            } else {

                history.add(
                    "(" + num1 + ") " +
                    operator + " " +
                    "(" + num2 + ") = " +
                    result
                );
            }

        } catch (ArithmeticException e) {

            System.out.println(
                "Calculation Error: " + e.getMessage()
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Invalid Operation: " + e.getMessage()
            );
        }
    }

    public static int getChoice(Scanner sc) {

        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    public static boolean calculateAgain(Scanner sc) {

        while (true) {

            System.out.println(
                "Want to calculate again? (y/Y or n/N)"
            );

            char c = sc.next().charAt(0);

            if (c == 'y' || c == 'Y') {
                return true;

            } else if (c == 'n' || c == 'N') {
                return false;

            } else {
                System.out.println(
                    "Please select y or n or Y or N"
                );
            }
        }
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator("my calculator");
        System.out.println(calculator.getCalculatorName());
        Scanner sc = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        while (true) {

            showMenu();

            try {

                int choice = getChoice(sc);

                if (choice == 1) {

                    performCalculation(
                        calculator,
                        sc,
                        history
                    );

                    boolean again = calculateAgain(sc);

                    if (!again) {
                        System.out.println("Calculator closed.");
                        break;
                    }

                } else if (choice == 2) {

                    showHistory(history);

                } else if (choice == 3) {

                    clearHistory(history);

                } else if (choice == 4) {

                    System.out.println("Calculator closed.");
                    break;

                } else {

                    System.out.println(
                        "Invalid choice. Please choose 1, 2, 3 or 4."
                    );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Please enter a number."
                );

                sc.nextLine();
            }
        }

        sc.close();
    }
}

