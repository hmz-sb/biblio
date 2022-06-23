package ma.cigma.biblio.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class CategoryDto implements Serializable {
    private  Long id;
    @NotNull(message = "*Please enter category name")
    @NotBlank(message = "*Please enter category name")
    private  String name;
    @NotNull(message = "*Please enter category short name")
    @NotBlank(message = "*Please enter category short name")
    private  String shortName;
    private  String notes;
    private  Date createDate;
}
