package info.duhovniy.mathclasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.commons.MathUtils;
import info.duhovniy.mathclasses.commons.MathUtilsImpl;
import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MathClassesTeacherApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(MathClassesTeacherApplicationTests.class);
    private final MathUtils mathUtils = new MathUtilsImpl();

    @Autowired
    private StudentService studentService;

    @Test
	public void calculate() {
        String infix = " 3*(5..+ 4  )/2 / 3  ";
        LOG.info("Infix: " + infix);

        try {
            String preparedString = mathUtils.prepareString(infix);
            LOG.info("Prepared string: " + preparedString);
            LOG.info("Postfix: " + mathUtils.infixToPostfix(preparedString));
            LOG.info("Result: " + mathUtils.expressionCounter(mathUtils.infixToPostfix(preparedString)));
        } catch (MathException e) {
            LOG.info(e.getMessage());
        }
    }

	@Test
    public void writeToMongo() {
        Map<String, Boolean> map = new LinkedHashMap<>();
        map.put("Expression1", true);
        map.put("Expression2", false);
        map.put("Expression3", true);
        map.put("Expression5", false);

        Student student = new Student();

        student.setName("Igor");
        student.setEmail("igor@gmail.com");
        student.setTotalRating(10);
        student.setLastTrainingDate(new Date());
        student.setLastLevelName("leve3");
        student.setExpressionHistory(map);

        studentService.createStudent(student);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        LOG.info(json);
    }
}
