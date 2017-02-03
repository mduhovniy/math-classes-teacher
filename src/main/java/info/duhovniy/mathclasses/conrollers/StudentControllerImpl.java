package info.duhovniy.mathclasses.conrollers;

import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteStudentById(String id) {
        studentService.deleteStudentById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @Override
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Student getStudentByName(@PathVariable("name") String name) {
        return studentService.findStudentByName(name);
    }

    @Override
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") String id) {
        return studentService.findStudentById(id);
    }
}
