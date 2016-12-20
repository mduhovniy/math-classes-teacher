package info.duhovniy.mathclasses.dao;


import info.duhovniy.mathclasses.dto.Expression;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressionRepository extends MongoRepository<Expression, String>{

}
