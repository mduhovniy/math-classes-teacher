package info.duhovniy.mathclasses.dao;

import info.duhovniy.mathclasses.dto.Level;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends MongoRepository<Level, String> {
}
