package ma.cigma.biblio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter @Getter @ToString
public class RoleDto implements Serializable {
    private  int id;
    private  String role;
}
