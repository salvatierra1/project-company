package jardin.empresa.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private String imageId;
    private String description;
    private String relevant;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime date_creation;

    public Gallery(String name, String imageUrl, String imageId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }
    public Gallery(Long id, String name, String imageUrl, String imageId, String description,  String relevant) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.description = description;
        this.relevant = description;
    }
}
