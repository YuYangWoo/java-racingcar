package calculator.domain;

import calculator.view.FormulaOutput;
import java.util.Arrays;

public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Operation fromString(String symbol) {
        return Arrays.stream(Operation.values())
            .filter(value -> value.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(FormulaOutput.ERROR_NOT_OPERATOR));
    }
}
