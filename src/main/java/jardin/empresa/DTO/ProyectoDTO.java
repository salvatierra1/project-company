package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProyectoDTO {

    private Long id;

    @NotBlank(message = "name no puede estar en blanco")
    private String name;

    @NotBlank(message = "imagen no puede estar en blanco")
    private String imagen;

    @NotBlank(message = "biografia no puede estar en blanco")
    private String biografia;

}
