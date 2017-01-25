package info.duhovniy.mathclasses.commons;


public interface MathUtils {

    String infixToPostfix(String infix);

    String prepareString(String input) throws MathException;

    double expressionCounter(String inputExpression);
}
