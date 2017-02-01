package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.dao.ExpressionRepository;
import info.duhovniy.mathclasses.dto.Expression;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpressionServiceImpl implements ExpressionService {

    private final ExpressionRepository expressionRepository;

    private final MathUtils mathUtils;

    @Override
    public Expression createExpression(Expression expression) {
        // TODO: check for right calculation of new expression

        return expressionRepository.insert(expression);
    }

    @Override
    public Expression updateExpression(Expression expression) {
        // TODO: check for right calculation of new expression

        return expressionRepository.save(expression);
    }

    private List<String> parseExpressionBody(String body) throws MathException {
        return mathUtils.prepareString(body);
    }

    @Override
    public Boolean validateExpression(Expression expression) {

        return null;
    }

    @Override
    public void deleteExpression(Expression expression) {
        expressionRepository.delete(expression);
    }

    @Override
    public Expression findExpressionById(String id) {
        return expressionRepository.findOne(id);
    }

    @Override
    public List<Expression> findAllExpressions() {
        return expressionRepository.findAll();
    }

    @Override
    public String fillExpression(Expression expression) {
        return null;
    }
}
