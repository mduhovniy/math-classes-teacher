package info.duhovniy.mathclasses.services;


import info.duhovniy.mathclasses.dto.Level;

import java.util.List;

public interface LevelService {

    Level createLevel(Level level);

    Level updateLevel(Level level);

    void deleteLevel(Level level);

    Level findLevelById(String id);

    List<Level> findAllLevels();
}
