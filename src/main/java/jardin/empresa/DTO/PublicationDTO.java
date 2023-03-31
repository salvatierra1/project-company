package jardin.empresa.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PublicationDTO {

    private Long id;

    private String biography;

    private String image;

    private boolean relevant;

    private LocalDate date_creation;

}
