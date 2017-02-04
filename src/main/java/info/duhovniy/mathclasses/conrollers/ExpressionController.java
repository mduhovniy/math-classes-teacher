package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Expression;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpressionController {

    ResponseEntity<Expression> createExpression(Expression expression);

    ResponseEntity<Expression> updateExpression(Expression expression);

    void deleteExpression(String id);

    ResponseEntity<Expression> getRandomExpression(String levelName);

    List<Expression> getAllExpressions();

    Expression getExpressionById(String id);

    ResponseEntity<List<String>> prepareExpression(String input);
}
