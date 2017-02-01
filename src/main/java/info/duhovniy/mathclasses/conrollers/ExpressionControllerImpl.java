package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Expression;
import info.duhovniy.mathclasses.services.ExpressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exp")
@AllArgsConstructor
public class ExpressionControllerImpl implements ExpressionController {

    private final ExpressionService expressionService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Expression> createExpression(Expression expression) {
        return new ResponseEntity<>(expressionService.createExpression(expression), HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Expression> updateExpression(Expression expression) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteExpression(Expression expression) {
        expressionService.deleteExpression(expression);
    }

    @Override
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ResponseEntity<Expression> getRandomExpression(String name) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Expression>> getAllExpressions() {
        return null;
    }
}
