package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Student;

import java.util.List;


public interface StudentController {

    Student createStudent(Student student);

    Student findStudentByName(String name);

    List<Student> findAllStudents();
}
