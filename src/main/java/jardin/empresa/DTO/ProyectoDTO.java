package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProyectoDTO {

    private Long id;

    @NotBlank(message = "name es obligatorio")
    private String name;

    @NotBlank(message = "imagen es obligatorio")
    private String imagen;

    @NotBlank(message = "biografia es obligatorio")
    private String biografia;

    private String mision;

    private String vision;

}
