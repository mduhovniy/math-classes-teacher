package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.dto.Expression;
import info.duhovniy.mathclasses.services.ExpressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.WebServiceException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exp")
@AllArgsConstructor
public class ExpressionControllerImpl implements ExpressionController {

    private final ExpressionService expressionService;

    @Override
    @PostMapping
    public ResponseEntity<Expression> createExpression(@Valid @RequestBody Expression expression) {
        if (expressionService.isExpressionValid(expression))
            return new ResponseEntity<>(expressionService.createExpression(expression), HttpStatus.OK);
        else
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    @PutMapping
    public ResponseEntity<Expression> updateExpression(@Valid @RequestBody Expression expression) {
        if (expressionService.isExpressionValid(expression))
            return new ResponseEntity<>(expressionService.updateExpression(expression), HttpStatus.OK);
        else
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    @DeleteMapping
    public void deleteExpression(@RequestParam String id) {
        expressionService.deleteExpression(id);
    }

    @Override
    @GetMapping(value = "/random/{level}")
    public ResponseEntity<Expression> getRandomExpression(@PathVariable("level") String levelName) {

        Expression randomExpression;
        try {
            randomExpression = expressionService.getRandomExpression(levelName);
            return new ResponseEntity<>(randomExpression, HttpStatus.OK);
        } catch (WebServiceException e) {
            // sending error code 422 - means NO Expressions found in this Level
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping(value = "/all")
    public List<Expression> getAllExpressions() {
        return expressionService.findAllExpressions();
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public Expression getExpressionById(@PathVariable("id") String id) {
        return expressionService.findExpressionById(id);
    }

    @Override
    @PostMapping(value = "/prepare")
    public ResponseEntity<List<String>> prepareExpression(@RequestBody String input) {
        List<String> expression = new ArrayList<>();
        try {
            expression = expressionService.prepareExpression(input);
            return new ResponseEntity<>(expression, HttpStatus.OK);
        } catch (MathException e) {
            // sending error description in first element of list together with error code 422
            expression.add(e.getMessage());
            return new ResponseEntity<>(expression, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
