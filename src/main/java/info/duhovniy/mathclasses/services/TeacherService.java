package info.duhovniy.mathclasses.services;

import info.duhovniy.mathclasses.dto.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher);

    Teacher updateLevel(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher findTeacherById(String id);

    List<Teacher> findAllTeachers();
}
