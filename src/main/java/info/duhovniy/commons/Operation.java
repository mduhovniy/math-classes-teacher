package info.duhovniy.commons;


public enum Operation {
    PLUS(1, "+"),
    MINUS(2, "-"),
    MULTIPLY(3, "*"),
    DIVIDE(4, "/"),
    EQUALS(0, "=");

    private int key;
    private String symbol;

    private Operation(int key, String symbol) {
        this.key = key;
        this.symbol = symbol;
    }

    public int getKey() {
        return key;
    }

    public String getSymbol() {
        return symbol;
    }
}
