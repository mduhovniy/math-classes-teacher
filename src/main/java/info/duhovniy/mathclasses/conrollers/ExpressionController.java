package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Expression;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpressionController {

    ResponseEntity<Expression> createExpression(Expression expression);

    ResponseEntity<Expression> updateExpression(Expression expression);

    void deleteExpression(Expression expression);

    ResponseEntity<Expression> getRandomExpression(String name);

    ResponseEntity<List<Expression>> getAllExpressions();
}
