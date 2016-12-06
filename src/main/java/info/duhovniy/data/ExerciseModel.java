package info.duhovniy.data;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ExerciseModel {

    @Id
    private String id;
    private String model;
    private int rating;
}
