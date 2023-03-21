package jardin.empresa.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PublicacionDTO {

    private Long id;

    @NotBlank(message = "biografia es obligatorio")
    private String biografia;

    @NotBlank(message = "imagen es obligatorio")
    private String imagen;

    private boolean destacado;

    private LocalDate fechaCreacion;

}
