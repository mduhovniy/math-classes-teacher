package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Level {

    @Id
    private String id;

    private String name;
    private String teacherName;
    private int rate;

    // Expression Id
    private List<String> expressions;
}
