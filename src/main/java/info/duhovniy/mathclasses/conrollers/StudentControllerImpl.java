package info.duhovniy.mathclasses.conrollers;

import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @Override
    @PutMapping
    public Student updateStudent(@Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @Override
    @DeleteMapping
    public void deleteStudentById(@RequestParam String id) {
        studentService.deleteStudentById(id);
    }

    @Override
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public Student getStudentByName(@PathVariable("name") String name) {
        return studentService.findStudentByName(name);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return studentService.findStudentById(id);
    }
}
