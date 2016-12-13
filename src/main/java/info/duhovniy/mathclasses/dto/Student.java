package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@Document
public class Student {

    @Id
    private String id;

    private String name;

    private String email;
    private int totalRating;
    private Date lastTrainingDate;
    private String lastLevelId;

    // Expression Id - isSolved
    private Map<String, Boolean> expressionHistory;
}
