package ma.cigma.biblio.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@ToString
@Table(name = "user")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public User() {}

    public User(@NotNull String displayName, @NotNull String username, @NotNull String password, @NotNull String role) {
        super();
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @NotNull
    @Column(name = "display_name")
    private String displayName;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "active")
    private Integer active;

    @NotNull
    @Column(name = "role")
    private String role;

    @NotNull
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;




    @ManyToMany
    @JoinColumn
    private List<Role> roles=new ArrayList<Role>();

}

