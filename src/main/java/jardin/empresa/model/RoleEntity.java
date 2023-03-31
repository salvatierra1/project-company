package jardin.empresa.model;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The name cannot be empty")
    private String name;

    @NotNull(message = "The name cannot be empty")
    private String password;

    public RoleEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
