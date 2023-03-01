package jardin.empresa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
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

    private String logoRedes;

    private String linkRedes;

    private boolean deleted = Boolean.FALSE;

}
