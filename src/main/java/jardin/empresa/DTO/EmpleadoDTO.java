package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmpleadoDTO {

    private Long id;

    @NotBlank(message = "name es obligatorio")
    private String name;

    @NotBlank(message = "apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "biografia es obligatorio")
    private String biografia;

    @NotBlank(message = "imagen es obligatorio")
    private String imagen;

}
