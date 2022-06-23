package ma.cigma.biblio.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDto implements Serializable {
    private  Long id;
    @NotEmpty(message = "*Please select member type")
    @NotNull(message = "*Please select member type")
    private  String type;
    @NotEmpty(message = "*Please enter fisrt name")
    @NotNull(message = "*Please enter fisrt name")
    private  String firstName;
    @NotEmpty(message = "*Please enter middle name")
    @NotNull(message = "*Please enter middle name")
    private  String middleName;
    private  String lastName;
    @NotEmpty(message = "*Please select gender")
    @NotNull(message = "*Please select gender")
    private  String gender;
    @NotNull(message = "*Please enter birth date")
    private  Date dateOfBirth;
    private  Date joiningDate;
    private  String contact;
    private  String email;
}
