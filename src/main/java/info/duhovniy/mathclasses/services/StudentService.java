package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(String id);

    Student findStudentByName(String name);

    Student findStudentById(String id);

    List<Student> findAllStudents();
}
