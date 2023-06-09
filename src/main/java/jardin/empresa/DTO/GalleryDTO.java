package jardin.empresa.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GalleryDTO {

    private Long id;

    private String imageId;

    private String name;

    private String imageUrl;

    private String description;

    private String alternative;


}
