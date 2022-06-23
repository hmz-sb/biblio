package ma.cigma.biblio.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserDto implements Serializable {
    private  Long id;
    @NotNull
    private  String displayName;
    @NotNull
    private  String username;
    @NotNull
    private  String password;
    @NotNull
    private  Integer active;
    @NotNull
    private  String role;
    @NotNull
    private  Date createdDate;
    private  Date lastModifiedDate;
}
