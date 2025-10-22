package utp.workpagespringutp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String username;
    private String password;
    private String email;
    private String nombreCompleto;

}
