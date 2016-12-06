package info.duhovniy;

import info.duhovniy.commons.Operation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.EnumSet;
import java.util.Iterator;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

        for (Operation o : Operation.values()) {
            System.out.println(o + " " + o.getKey() + " " + o.getSymbol() + " " + o.getClass() );
        }

    }
}
