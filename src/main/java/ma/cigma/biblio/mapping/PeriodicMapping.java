package ma.cigma.biblio.mapping;

import ma.cigma.biblio.dto.BookDto;
import ma.cigma.biblio.dto.PeriodicDto;
import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Periodic;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PeriodicMapping {

    ModelMapper modelMapper=new ModelMapper();

    public PeriodicDto periodicDtoToBo(Periodic periodic) {
        PeriodicDto periodicDto=modelMapper.map(periodic,PeriodicDto.class);
        return periodicDto;
    }


    public Periodic periodicBoToDto(Periodic periodicDto) {
        Periodic periodic=modelMapper.map(periodicDto,Periodic.class);
        return periodic;

    }
}
