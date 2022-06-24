package ma.cigma.biblio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.cigma.biblio.entities.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class PeriodicDto implements Serializable {

    private  Long id;
    private NotBlank title;
    private  String tag;
    private  String authors;
    private  String publisher;
    private  String isbn;
    private  Integer status;
    private Date createDate;
    private Document document;
}
