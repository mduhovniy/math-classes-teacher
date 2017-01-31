package info.duhovniy.mathclasses.commons;


import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface MathUtils {

    String infixToPostfix(String infix);

    List<String> infixToPostfixList(List<String> infix);

    List<String> prepareString(String input) throws MathException;

    double calculateExpression(List<String> inputExpression);

    double calculateExpression(Expression inputExpression);

    void devalueExpression(String input);

    String evaluateExpression(Expression expression);

    List<String> evaluateExpressionList(Expression expression);
}
