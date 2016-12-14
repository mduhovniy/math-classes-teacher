package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document
public class Teacher {

    @Id
    private String id;

    private String name;
    private String email;

    // Student Name - Active
    private Map<String, Boolean> students;

    // Level Name - Level Rate
    private Map<String, Integer> levels;
}
