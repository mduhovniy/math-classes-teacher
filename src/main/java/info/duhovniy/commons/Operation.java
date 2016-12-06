package info.duhovniy.commons;


public enum Operation {

    PLUS(1, "+", (x, y) -> x+y),
    MINUS(1, "-", (x, y) -> x-y),
    MULTIPLY(2, "*", (x, y) -> x*y),
    DIVIDE(2, "/", (x, y) -> x/y);

    private String symbol;
    private int priority;
    private MathOperation lambda;

    Operation(String symbol, int priority, MathOperation lambda) {
        this.symbol = symbol;
        this.priority = priority;
        this.lambda = lambda;
    }

    public int getKey() {
        return priority;
    }

    public MathOperation getLambda() {
        return lambda;
    }

    public String getSymbol() { return symbol; }
}
