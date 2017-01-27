package info.duhovniy.mathclasses.commons;


import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface MathUtils {

    String infixToPostfix(String infix);

    List<String> prepareString(String input) throws MathException;

    double expressionCounter(String inputExpression);

    String devalueExpression(String input);

    String evaluateExpression(Expression expression);
}
