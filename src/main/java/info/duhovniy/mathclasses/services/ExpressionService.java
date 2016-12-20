package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Expression;
import java.util.List;

public interface ExpressionService {

    Expression createExpression(Expression expression);

    Expression updateExpression(Expression expression);

    void deleteExpression(Expression student);

    Expression findExpressionById(String id);

    List<Expression> findAllExpressions();
}
