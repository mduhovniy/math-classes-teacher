package info.duhovniy.mathclasses.services;

import info.duhovniy.mathclasses.dao.TeacherRepository;
import info.duhovniy.mathclasses.dto.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.insert(teacher);
    }

    @Override
    public Teacher updateLevel(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }
}
