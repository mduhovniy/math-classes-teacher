package info.duhovniy.mathclasses.services;

import info.duhovniy.mathclasses.dao.StudentRepository;
import info.duhovniy.mathclasses.dto.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.insert(student);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
