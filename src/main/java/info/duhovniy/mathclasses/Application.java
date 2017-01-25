package info.duhovniy.mathclasses;


import info.duhovniy.mathclasses.commons.MathUtils;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class Application {

    private final MathUtils mathUtils;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "math-classes-server");
        SpringApplication.run(Application.class, args);
    }
}
