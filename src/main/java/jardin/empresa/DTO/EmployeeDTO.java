package jardin.empresa.DTO;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long id;

    private String name;

    private String last_name;

    private String title;

    private String biography;

    private String image;
}
