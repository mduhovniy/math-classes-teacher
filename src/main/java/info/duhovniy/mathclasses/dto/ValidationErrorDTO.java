package info.duhovniy.mathclasses.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class ValidationErrorDTO {

    private List<FieldErrorDTO> fieldErrorDTOS = new ArrayList<>();

    public void addFieldError(String path, String message) {
        fieldErrorDTOS.add(new FieldErrorDTO(path, message));
    }
}
