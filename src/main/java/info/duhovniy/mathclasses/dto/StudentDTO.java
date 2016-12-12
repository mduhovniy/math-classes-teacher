package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class StudentDTO {

    @Id
    private String id;

    private String name;
    private int totalRating;
    private Date lastTrainingDate;
}
