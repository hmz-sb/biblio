package ma.cigma.biblio.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "issued_book")
public class IssuedBook implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @NotNull
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "issue_id")
    @NotNull
    private Issue issue;

    @Column(name = "returned")
    private Integer returned;



}
