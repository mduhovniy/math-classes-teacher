package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@Document
public class Expression {

    @Id
    private String id;

    @NotEmpty(message = "Error: Expression should have Level name")
    private String levelName;

    // Rating within Level
    private int rating;

    // time limit for solution
    @NotEmpty(message = "Error: Max time in seconds for solution expected")
    private int maxTimeInSeconds;

    // Expression Pattern
    @NotEmpty(message = "Error: Expression can not be empty")
    private List<String> body;

    // Range of random expression parameters
    @NotEmpty(message = "Error: Min range of expression param can not be NULL")
    private int min;
    @NotEmpty(message = "Error: Max range of expression param can not be NULL")
    private int max;
    // Number of digits after dot, NULL == 0
    @Min(value = 0, message = "Error: Rank should not be < 0")
    private int rank;
}
