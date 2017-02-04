package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@Document
public class Student {

    @Id
    private String id;

    @NotEmpty(message = "Error: Student name could not be empty")
    @Length(min = 2, message = "Error: Student name could not be less than 2 symbols")
    private String name;
    @NotEmpty(message = "Error: Student email could not be empty")
    @Email(message = "Error: Student email not valid")
    private String email;
    // Sum of Level (Rate * Expression Rating) for each solved expression
    private int totalRating;
    private Date lastTrainingDate;
    private String lastLevelName;

    // Expression Id - isSolved?
    private Map<String, Boolean> expressionHistory;
}
