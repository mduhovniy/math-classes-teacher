package info.duhovniy.mathclasses;

import com.mongodb.MongoClient;
import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.commons.MathUtilsImpl;
import info.duhovniy.mathclasses.services.StudentService;
import info.duhovniy.mathclasses.services.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories
public class AppConfig {

    @Bean
    public MathUtils mathUtils() {
        return new MathUtilsImpl();
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "mathclasses");
    }
}
