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
        return expressionRepository.insert(expression);
    }

    @Override
    public Expression updateExpression(Expression expression) {
        return expressionRepository.save(expression);
    }

    @Override
    public Boolean isExpressionValid(Expression expression) {
        try {
            mathUtils.calculateExpression(expression);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> prepareExpression(String input) throws MathException {
        return mathUtils.prepareString(input);
    }

    @Override
    public void deleteExpression(String id) {
        expressionRepository.delete(id);
    }

    @Override
    public Expression findExpressionById(String id) {
        return expressionRepository.findOne(id);
    }

    @Override
    public List<Expression> findAllExpressions() {
        return expressionRepository.findAll();
    }
}
