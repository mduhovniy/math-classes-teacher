package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.dto.Expression;
import info.duhovniy.mathclasses.services.ExpressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exp")
@AllArgsConstructor
public class ExpressionControllerImpl implements ExpressionController {

    private final ExpressionService expressionService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Expression> createExpression(@Valid @RequestBody Expression expression) {
        if (expressionService.isExpressionValid(expression))
            return new ResponseEntity<>(expressionService.createExpression(expression), HttpStatus.OK);
        else
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Expression> updateExpression(@Valid @RequestBody Expression expression) {
        if (expressionService.isExpressionValid(expression))
            return new ResponseEntity<>(expressionService.updateExpression(expression), HttpStatus.OK);
        else
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteExpression(String id) {
        expressionService.deleteExpression(id);
    }

    @Override
    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ResponseEntity<Expression> getRandomExpression(String name) {
        return null;
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Expression> getAllExpressions() {
        return expressionService.findAllExpressions();
    }

    @Override
    public ResponseEntity<List<String>> prepareExpression(String input) {
        List<String> expression = new ArrayList<>();
        try {
            expression = expressionService.prepareExpression(input);
            return new ResponseEntity<>(expression, HttpStatus.OK);
        } catch (MathException e) {
            // sending error description in first element of list together with error code 422
            expression.add(e.toString());
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
