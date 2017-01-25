package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface ExpressionService {

    Expression createExpression(Expression expression);

    Expression updateExpression(Expression expression);

    void deleteExpression(Expression expression);

    Expression findExpressionById(String id);

    List<Expression> findAllExpressions();

    String fillExpression(Expression expression);
}
