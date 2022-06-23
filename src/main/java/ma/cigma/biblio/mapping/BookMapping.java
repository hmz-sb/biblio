package ma.cigma.biblio.mapping;

import ma.cigma.biblio.dto.BookDto;
import ma.cigma.biblio.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapping {

    ModelMapper modelMapper=new ModelMapper();

    public BookDto bookDtoToBo(Book book) {
        BookDto bookDto=modelMapper.map(book,BookDto.class);
        return bookDto;
    }


    public Book bookBoToDto(Book bookDto) {
        Book book=modelMapper.map(bookDto,Book.class);
        return book;

    }
}
