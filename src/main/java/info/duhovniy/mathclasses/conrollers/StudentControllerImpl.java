package info.duhovniy.mathclasses.conrollers;

import info.duhovniy.mathclasses.dto.Student;
import info.duhovniy.mathclasses.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentControllerImpl implements StudentController {

    private StudentService studentService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteStudent(Student student) {
        studentService.deleteStudent(student);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Student findStudentByName(@RequestParam("name") String name) {
        return studentService.findStudentByName(name);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public Student findStudentById(@RequestParam("id") String id) {
        return studentService.findStudentById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
