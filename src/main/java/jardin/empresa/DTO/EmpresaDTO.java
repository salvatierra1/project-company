package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmpresaDTO {

    private Long id;

    @NotBlank(message = "name es obligatorio")
    private String name;

    @NotBlank(message = "ubicacion es obligatorio")
    private String ubicacion;

    @NotBlank(message = "resolucion es obligatorio")
    private String resolucion;

    @NotBlank(message = "biografia es obligatorio")
    private String biografia;

    @NotBlank(message = "biografia es obligatorio")
    private String horarios;

    @NotBlank(message = "biografia es obligatorio")
    private String telefono;

    @NotBlank(message = "biografia es obligatorio")
    private String email;

    @NotBlank(message = "imagen es obligatorio")
    private String imagen;

    private String linkIg;

    private String linkFb;

    private String linkLk;

    private String mision;

    private String vision;

}
