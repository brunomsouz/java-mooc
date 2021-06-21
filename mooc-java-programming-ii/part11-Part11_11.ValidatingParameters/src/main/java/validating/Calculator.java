package validating;

public class Calculator {

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Argument less than 0");
        }
        
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("One of the arguments is negative");
        } else if (subsetSize > setSize) {
            throw new IllegalArgumentException("Second argument can't exceed the first argument");
        }
        
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
