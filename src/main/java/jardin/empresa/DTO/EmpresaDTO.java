package jardin.empresa.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmpresaDTO {

    private Long id;

    @NotBlank(message = "Name no puede estar en blanco")
    private String name;

    @NotBlank(message = "ubicacion no puede estar en blanco")
    private String ubicacion;

    @NotBlank(message = "resolucion no puede estar en blanco")
    private String resolucion;

    @NotBlank(message = "biografia no puede estar en blanco")
    private String biografia;

    @NotBlank(message = "imagen no puede estar en blanco")
    private String imagen;

    @NotBlank(message = "logoRedes no puede estar en blanco")
    private String logoRedes;

    @NotBlank(message = "linkRedes no puede estar en blanco")
    private String linkRedes;
}
