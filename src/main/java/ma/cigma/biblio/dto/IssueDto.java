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
public class IssueDto implements Serializable {
    private  Long id;
    @NotNull
    private Date issueDate;
    private  String notes;
    private  Date expectedReturnDate;
    private  Integer returned;
}
