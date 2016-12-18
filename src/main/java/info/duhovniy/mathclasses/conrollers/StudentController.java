package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Student;

import java.util.List;


public interface StudentController {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Student student);

    Student findStudentByName(String name);

    Student findStudentById(String id);

    List<Student> findAllStudents();
}
