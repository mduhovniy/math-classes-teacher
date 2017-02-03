package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Student;

import java.util.List;


public interface StudentController {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(String id);

    Student getStudentByName(String name);

    Student getStudentById(String id);

    List<Student> getAllStudents();
}
