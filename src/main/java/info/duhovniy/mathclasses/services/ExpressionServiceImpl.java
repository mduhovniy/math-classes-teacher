package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dao.ExpressionRepository;
import info.duhovniy.mathclasses.dto.Expression;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpressionServiceImpl implements ExpressionService {

    private ExpressionRepository expressionRepository;

    @Override
    public Expression createExpression(Expression expression) {
        return expressionRepository.insert(expression);
    }

    @Override
    public Expression updateExpression(Expression expression) {
        return expressionRepository.save(expression);
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
