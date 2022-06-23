package ma.cigma.biblio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "member")
public class Member implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "*Please select member type")
    @NotNull(message = "*Please select member type")
    @Column(name = "type")
    private String type;

    @NotEmpty(message = "*Please enter fisrt name")
    @NotNull(message = "*Please enter fisrt name")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "*Please enter middle name")
    @NotNull(message = "*Please enter middle name")
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "*Please select gender")
    @NotNull(message = "*Please select gender")
    @Column(name = "gender")
    private String gender;

    @NotNull(message = "*Please enter birth date")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    public Member(@NotNull String type, @NotNull String firstName, @NotNull String middleName, @NotNull String lastName,
                  @NotNull String gender, @NotNull Date dateOfBirth, @NotNull Date joiningDate) {
        super();
        this.type = type;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = joiningDate;
    }



}

