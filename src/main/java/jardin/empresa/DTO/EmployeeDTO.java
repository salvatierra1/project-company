package jardin.empresa.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

    private Long id;

    private String imageId;

    private String name;

    private String last_name;

    private String title;

    private String biography;

    private String imageUrl;
}
