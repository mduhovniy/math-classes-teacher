package info.duhovniy.mathclasses.services;

import info.duhovniy.mathclasses.dao.StudentRepository;
import info.duhovniy.mathclasses.dto.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public Student findStudentByName(String name) {
        return studentRepository.findOne(name);
    }
}
