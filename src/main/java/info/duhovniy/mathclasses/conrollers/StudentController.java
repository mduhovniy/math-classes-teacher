package info.duhovniy.mathclasses.conrollers;


import info.duhovniy.mathclasses.dto.Student;


public interface StudentController {

    Student createStudent(Student student);

    Student findStudentByName(String name);
}
