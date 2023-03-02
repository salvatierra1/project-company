package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmpleadoDTO {

    private Long id;

    @NotBlank(message = "Name no puede estar en blanco")
    private String name;

    @NotBlank(message = "apellido no puede estar en blanco")
    private String apellido;

    @NotBlank(message = "titulo no puede estar en blanco")
    private String titulo;

    @NotBlank(message = "biografia no puede estar en blanco")
    private String biografia;

    @NotBlank(message = "imagen no puede estar en blanco")
    private String imagen;

}
