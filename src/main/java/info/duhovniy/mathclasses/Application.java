package info.duhovniy.mathclasses;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "math-classes-server");
        SpringApplication.run(Application.class, args);
    }
}
