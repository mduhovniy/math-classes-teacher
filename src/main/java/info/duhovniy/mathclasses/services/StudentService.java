package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Student;

public interface StudentService {

    void createStudent(Student student);

    Student findStudentByName(String name);
}
