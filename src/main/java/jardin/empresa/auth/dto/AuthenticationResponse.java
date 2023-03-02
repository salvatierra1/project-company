package jardin.empresa.auth.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String jwt;

}