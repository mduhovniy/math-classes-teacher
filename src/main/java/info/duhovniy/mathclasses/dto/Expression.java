package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Expression {

    @Id
    private String id;

    private String teacherName;
    private String levelName;
    private int rating;
    private int maxTimeInSeconds;

    // Expression Pattern
    private List<String> body;
}
