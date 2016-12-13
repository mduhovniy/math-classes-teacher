package info.duhovniy.mathclasses.dao;


import info.duhovniy.mathclasses.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableMongoRepositories
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findStudentByName(String name);
}
