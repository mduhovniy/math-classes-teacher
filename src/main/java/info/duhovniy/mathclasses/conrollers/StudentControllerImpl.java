package info.duhovniy.mathclasses.conrollers;

import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private StudentService studentService;

    @Override
    @RequestMapping(value = "/api/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return student;
    }

    @Override
    @RequestMapping(value = "/api/students/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student findStudentByName(@PathVariable("name") String name) {
        return studentService.findStudentByName(name);
    }
}
