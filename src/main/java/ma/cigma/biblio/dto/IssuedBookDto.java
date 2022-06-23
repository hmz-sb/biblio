package ma.cigma.biblio.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class IssuedBookDto implements Serializable {
    private  Long id;
    private  Integer returned;
}
