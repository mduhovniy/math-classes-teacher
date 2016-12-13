package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document
public class Level {

    @Id
    private String name;

    private int rate;

    // Expression Id - Expression Rating
    private Map<String, Integer> expressions;
}
