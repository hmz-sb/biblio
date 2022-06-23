package ma.cigma.biblio.mapping;


import ma.cigma.biblio.dto.IssuedBookDto;
import ma.cigma.biblio.entities.IssuedBook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IssuedBookMapping {
    ModelMapper modelMapper=new ModelMapper();

    public IssuedBookDto issuedBookDtoToBo(IssuedBook issuedBook) {
        IssuedBookDto issuedBookDto=modelMapper.map(issuedBook,IssuedBookDto.class);
        return issuedBookDto;
    }


    public IssuedBook issuedBookBoToDto(IssuedBook issuedBookDto) {
        IssuedBook issuedBook=modelMapper.map(issuedBookDto, IssuedBook.class);
        return issuedBook;

    }
}
