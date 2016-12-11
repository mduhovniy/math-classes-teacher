package info.duhovniy.mathclasses;


import info.duhovniy.mathclasses.commons.MathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

    private final MathUtils mathUtils;

    @Autowired
    public Application(MathUtils mathUtils) {
        this.mathUtils = mathUtils;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String infix = " 2* yyy .4   /2^2 +2*0.3     ";
        System.out.printf("Infix: %s%n", infix);
        System.out.printf("Prepared string: %s%n", mathUtils.prepareString(infix));
        System.out.printf("Postfix: %s%n", mathUtils.infixToPostfix(mathUtils.prepareString(infix)));
        System.out.println("Result: %d%n" + mathUtils.expressionCounter(mathUtils.infixToPostfix(mathUtils.prepareString(infix))));
    }
}
