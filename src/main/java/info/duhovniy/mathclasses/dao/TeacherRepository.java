package info.duhovniy.mathclasses.dao;


import info.duhovniy.mathclasses.dto.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
