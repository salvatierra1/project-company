package jardin.empresa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE empresa SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ubicacion;

    private String resolucion;

    private String biografia;

    private String imagen;

    private String horarios;

    private String telefono;

    private String email;

    private String linkRedes;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaCreacion;

    private boolean deleted = Boolean.FALSE;

}
