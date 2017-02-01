package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Expression;
import info.duhovniy.mathclasses.services.ExpressionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exp")
@AllArgsConstructor
public class ExpressionControllerImpl implements ExpressionController {

    private final ExpressionService expressionService;

    @Override
    public Expression createExpression(Expression expression) {
        return null;
    }

    @Override
    public Expression updateExpression(Expression expression) {
        return null;
    }

    @Override
    public void deleteExpression(Expression expression) {

    }

    @Override
    public Expression getRandomExpression(String name) {
        return null;
    }

    @Override
    public List<Expression> getAllExpressions() {
        return null;
    }
}
