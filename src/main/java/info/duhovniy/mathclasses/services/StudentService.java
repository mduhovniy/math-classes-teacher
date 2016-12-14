package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student findStudentByName(String name);

    List<Student> findAllStudents();
}
