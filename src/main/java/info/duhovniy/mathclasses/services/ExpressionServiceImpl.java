package info.duhovniy.mathclasses.services;


import com.mongodb.BasicDBObject;
import info.duhovniy.mathclasses.commons.CustomAggregationOperation;
import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.dao.ExpressionRepository;
import info.duhovniy.mathclasses.dto.Expression;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceException;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpressionServiceImpl implements ExpressionService {

    private final ExpressionRepository expressionRepository;

    private final MathUtils mathUtils;

    private final MongoTemplate mongoTemplate;

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
    public Long countExpressionsInLevel(String levelName) {
        return expressionRepository.countByLevelName(levelName);
    }

    @Override
    public Expression getRandomExpression(String levelName) throws WebServiceException {
        Aggregation aggregation = Aggregation.newAggregation(
                // Standard match pipeline stage
                Aggregation.match(
                        Criteria.where("levelName").is(levelName)
                ),
                // custom pipeline stage
                new CustomAggregationOperation(
                        new BasicDBObject(
                                "$sample",
                                new BasicDBObject("size", 15)
                        )
                )
        );

        AggregationResults<Expression> groupResults
                = mongoTemplate.aggregate(aggregation, Expression.class, Expression.class);
        List<Expression> result = groupResults.getMappedResults();

        if (result.isEmpty())
            throw new WebServiceException("Error: Requested Level is absent");
        else
            return result.get(0);
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
