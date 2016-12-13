package info.duhovniy.mathclasses;

import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.commons.MathUtilsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MathClassesTeacherApplicationTests {

    private final MathUtils mathUtils = new MathUtilsImpl();

    @Test
	public void calculate() {
        String infix = " 3*(5+ 4  )/2 / 3  ";

        System.out.println("Infix: " + infix);
        System.out.println("Prepared string: " + mathUtils.prepareString(infix));
        System.out.println("Postfix: " + mathUtils.infixToPostfix(mathUtils.prepareString(infix)));
        System.out.println("Result: " + mathUtils.expressionCounter(mathUtils.infixToPostfix(mathUtils.prepareString(infix))));
	}

}
