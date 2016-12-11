package info.duhovniy.mathclasses.data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Student {

    @Id
    private String id;

    private String name;
    private int totalRating;
    private Date lastTrainingDate;

    public Student() {}
}
