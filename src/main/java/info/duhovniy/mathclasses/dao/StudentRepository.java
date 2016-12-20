package info.duhovniy.mathclasses.dao;


import info.duhovniy.mathclasses.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findStudentByName(String name);

    Student findStudentById(String id);
}
