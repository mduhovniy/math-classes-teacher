package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Document
public class Expression {

    @Id
    private String id;

    @NotEmpty(message = "Error: Expression should have Level name")
    private String levelName;

    // Rating within Level
    @Min(value = 1, message = "Error: Rating should be > 0")
    private int rating;

    // time limit for solution
    @NotNull(message = "Error: Max time in seconds for solution expected")
    private int maxTimeInSeconds;

    // Expression Pattern
    @NotEmpty(message = "Error: Expression could not be empty")
    private List<String> body;

    // Range of random expression parameters
    @NotNull(message = "Error: Min range of expression param could not be NULL")
    private int min;
    @NotNull(message = "Error: Max range of expression param could not be NULL")
    private int max;
    // Number of digits after dot, NULL == 0
    @Min(value = 0, message = "Error: Rank should be >= 0")
    private int rank;
    // Temporary field for result of evaluated expression to verify on client
    private double tempResult;
}
