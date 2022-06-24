package ma.cigma.biblio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "book")
public class Book  extends Document implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;




    @JoinColumn(name = "title")
    @NotNull(message = "*Please enter book title")
    @NotBlank(message = "*Please enter book title")
    private String Title;

    @NotNull(message = "*Please enter book tag")
    @NotBlank(message = "*Please enter book tag")
    @Column(name = "tag")
    private String tag;

    @NotNull(message = "*Please enter book authors")
    @NotBlank(message = "*Please enter book authors")
    @Column(name = "authors")
    private String authors;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_date")
    private Date createDate;



    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;


}

