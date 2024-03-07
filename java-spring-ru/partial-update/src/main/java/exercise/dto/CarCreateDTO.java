package exercise.dto;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Setter
@Getter
public class CarCreateDTO {

    private String model;
    private String manufacturer;
    private int enginePower;
}
