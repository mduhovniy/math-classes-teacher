package info.duhovniy.mathclasses.commons;


public enum Operator {

    PLUS(1, '+', (x, y) -> x+y),
    MINUS(1, '-', (x, y) -> x-y),
    MODULE(2, '%', (x, y) -> x%y),
    MULTIPLY(3, '*', (x, y) -> x*y),
    DIVIDE(3, '/', (x, y) -> x/y),
    POWER(4, '^', Math::pow);


    private int priority;
    private Character symbol;
    private BinaryMathOperation lambda;

    Operator(int priority, Character symbol, BinaryMathOperation lambda) {
        this.symbol = symbol;
        this.priority = priority;
        this.lambda = lambda;
    }

    public int getPriority() {
        return priority;
    }

    public BinaryMathOperation getLambda() {
        return lambda;
    }

    public Character getSymbol() { return symbol; }
}
