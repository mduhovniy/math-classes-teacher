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

    private String levelName;
    // Rating within Level
    private int rating;
    // time limit for solution
    private int maxTimeInSeconds;

    // Expression Pattern
    private List<String> body;
    // Range of random expression parameters
    private int min;
    private int max;
    // Number of digits after dot
    private int rank;
}
