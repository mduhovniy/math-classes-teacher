package info.duhovniy.mathclasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.duhovniy.mathclasses.commons.MathException;
import info.duhovniy.mathclasses.dto.Expression;
import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.ExpressionService;
import info.duhovniy.mathclasses.services.MathService;
import info.duhovniy.mathclasses.services.MathServiceImpl;
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
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MathClassesTeacherApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(MathClassesTeacherApplicationTests.class);
    private final MathService mathService = new MathServiceImpl();

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExpressionService expressionService;

    @Test
	public void calculate() {
        String infix = "3*5-1";
        LOG.info("Infix: " + infix);

        try {
            List<String> preparedList = mathService.prepareString(infix);
            LOG.info("Prepared list: " + preparedList);
            //LOG.info("Postfix list: " + mathService.infixToPostfixList(preparedList));
            Expression ex = new Expression();
            ex.setBody(preparedList);
            ex.setMin(-50);
            ex.setMax(50);
            ex.setRank(1);
            double x = mathService.calculateExpression(ex);
            LOG.info("Result from expression: " + x);

            //LOG.info("Evaluated string: " + mathService.evaluateExpressionToString(ex));
            //LOG.info("Evaluated list: " + mathService.evaluateExpressionToList(ex));
            LOG.info("Evaluated list: " + mathService.evaluateExpressionToExpression(ex));
        } catch (MathException e) {
            LOG.info(e.getMessage());
        }
    }

	@Test
    public void writeStudentToMongo() {
        Map<String, Boolean> map = new LinkedHashMap<>();
        map.put("Expression1", true);
        map.put("Expression2", false);
        map.put("Expression3", true);
        map.put("Expression5", false);

        Student student = new Student();

        student.setName("Leo");
        student.setEmail("leo@gmail.com");
        student.setTotalRating(5);
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

    @Test
    public void writeExpressionToMongo() throws MathException {

        Expression exp = new Expression();

        exp.setBody(expressionService.prepareExpression("3 * 7 + 5/2"));
        exp.setLevelName("level1");
        exp.setMax(10);
        exp.setMin(0);
        exp.setMaxTimeInSeconds(60);
        exp.setRank(0);
        exp.setRating(5);

        expressionService.createExpression(exp);
    }
}
