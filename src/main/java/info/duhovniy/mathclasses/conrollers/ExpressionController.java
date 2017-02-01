package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Expression;

import java.util.List;

public interface ExpressionController {

    Expression createExpression(Expression expression);

    Expression updateExpression(Expression expression);

    void deleteExpression(Expression expression);

    Expression getRandomExpression(String name);

    List<Expression> getAllExpressions();
}
