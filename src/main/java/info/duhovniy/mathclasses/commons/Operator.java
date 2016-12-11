package info.duhovniy.mathclasses.commons;


public enum Operator {

    // Binary operators in Priority order - Ascending
    PLUS('+', (x, y) -> x+y),
    MINUS('-', (x, y) -> x-y),
    MODULE('%', (x, y) -> x%y),
    MULTIPLY('*', (x, y) -> x*y),
    DIVIDE('/', (x, y) -> x/y),
    POWER('^', Math::pow);

    private Character symbol;
    private BinaryMathOperation lambda;

    Operator(Character symbol, BinaryMathOperation lambda) {
        this.symbol = symbol;
        this.lambda = lambda;
    }

    public BinaryMathOperation getLambda() {
        return lambda;
    }

    public Character getSymbol() { return symbol; }
}
