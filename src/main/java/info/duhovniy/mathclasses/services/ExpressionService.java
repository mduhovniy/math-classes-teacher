package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface ExpressionService {

    Expression createExpression(Expression expression);

    Expression updateExpression(Expression expression);

    void deleteExpression(String id);

    Expression findExpressionById(String id);

    List<Expression> findAllExpressions();

    Boolean isExpressionValid(Expression expression);

    // move to separate service???
    List<String> prepareExpression(String input) throws MathException;

}
