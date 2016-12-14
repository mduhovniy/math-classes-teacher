package info.duhovniy.mathclasses.conrollers;

import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private StudentService studentService;

    @Override
    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @Override
    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student findStudentByName(@PathVariable String name) {
        return studentService.findStudentByName(name);
    }

    @Override
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
