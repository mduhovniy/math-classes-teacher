package info.duhovniy.mathclasses;


import info.duhovniy.mathclasses.commons.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private final MathUtils mathUtils;

    @Autowired
    public Application(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
