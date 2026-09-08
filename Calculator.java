public class Calculator {
    private String calculatorName;

    public Calculator(String name){
        this.calculatorName = name;
    }

    public String getCalculatorName() {
    return calculatorName;
    
    }
    public void setCalculatorName(String calculatorName) {
    this.calculatorName = calculatorName;

    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot perform modulus by zero.");
        }
        return a % b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException(
                "Cannot calculate square root of a negative number."
            );
        }
        return Math.sqrt(a);
    }
}