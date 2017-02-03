package info.duhovniy.mathclasses.dto;


import lombok.Data;
import lombok.NonNull;

@Data
public class FieldErrorDTO {

    @NonNull
    private String field;
    @NonNull
    private String message;
}
