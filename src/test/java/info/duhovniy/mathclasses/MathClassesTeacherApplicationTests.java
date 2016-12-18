package info.duhovniy.mathclasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.commons.MathUtilsImpl;
import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MathClassesTeacherApplicationTests {

    private final MathUtils mathUtils = new MathUtilsImpl();

    @Autowired
    private StudentService studentService;

    @Test
	public void calculate() {
        String infix = " 3*(5+ 4  )/2 / 3  ";

        System.out.println("Infix: " + infix);
        System.out.println("Prepared string: " + mathUtils.prepareString(infix));
        System.out.println("Postfix: " + mathUtils.infixToPostfix(mathUtils.prepareString(infix)));
        System.out.println("Result: " + mathUtils.expressionCounter(mathUtils.infixToPostfix(mathUtils.prepareString(infix))));
	}

	@Test
    public void writeToMongo() {
        Map<String, Boolean> map = new LinkedHashMap<>();
        map.put("Expression10", true);
        map.put("Expression11", false);
        map.put("Expression12", true);
        map.put("Expression13", false);

        Student student = new Student();

        student.setName("Mike");
        student.setEmail("mike@gmail.com");
        student.setTotalRating(99);
        student.setLastTrainingDate(new Date());
        student.setLastLevelName("level2");
        student.setExpressionHistory(map);

        studentService.createStudent(student);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
