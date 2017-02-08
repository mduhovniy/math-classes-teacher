package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface MathService {

    List<String> prepareString(String input) throws MathException;

    double calculateExpression(Expression inputExpression) throws MathException;

    Expression evaluateExpressionToExpression(Expression expression) throws MathException;
}
