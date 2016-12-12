package info.duhovniy.mathclasses.dto;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ExpressionDTO {

    @Id
    private String id;

    private List<String> body;
    private String scope;
    private int rating;
}
