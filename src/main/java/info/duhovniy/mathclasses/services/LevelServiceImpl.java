package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dao.LevelRepository;
import info.duhovniy.mathclasses.dto.Level;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {

    private LevelRepository levelRepository;

    @Override
    public Level createLevel(Level level) {
        return levelRepository.insert(level);
    }

    @Override
    public Level updateLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public void deleteLevel(Level level) {
        levelRepository.delete(level);
    }

    @Override
    public Level findLevelById(String id) {
        return levelRepository.findOne(id);
    }

    @Override
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }
}
