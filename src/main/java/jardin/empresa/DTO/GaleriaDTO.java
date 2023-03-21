package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GaleriaDTO {

    private Long id;

    @NotBlank(message = "name es obligatorio")
    private String descripcion;

    @NotBlank(message = "imagen es obligatorio")
    private String imagen;

    @NotBlank(message = "alternativo es obligatorio")
    private String alternativo;
}
