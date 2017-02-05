package info.duhovniy.mathclasses.commons;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

@AllArgsConstructor
public class CustomSampleOperation implements AggregationOperation {

    private final int size;

    @Override
    public DBObject toDBObject(final AggregationOperationContext context) {
        return new BasicDBObject("$sample", new BasicDBObject("size", size));
    }
}
