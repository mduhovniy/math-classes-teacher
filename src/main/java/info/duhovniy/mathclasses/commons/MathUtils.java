package info.duhovniy.mathclasses.commons;


import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface MathUtils {

    String infixToPostfix(String infix);

    List<String> infixToPostfixList(List<String> infix);

    List<String> prepareString(String input) throws MathException;

    double calculateExpression(List<String> inputExpression);

    double calculateExpression(Expression inputExpression) throws MathException;

    void devalueExpression(String input);

    String evaluateExpressionToString(Expression expression);

    List<String> evaluateExpressionToList(Expression expression);

    Expression evaluateExpressionToExpression(Expression expression);
}
