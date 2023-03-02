package jardin.empresa.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@SQLDelete(sql = "UPDATE galeria SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Galeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imagen;

    private String alternativo;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaCreacion;

    private boolean deleted = Boolean.FALSE;
}
