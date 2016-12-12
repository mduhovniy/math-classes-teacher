package info.duhovniy.mathclasses;

import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.commons.MathUtilsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MathUtils mathUtils() {
        return new MathUtilsImpl();
    }
}
