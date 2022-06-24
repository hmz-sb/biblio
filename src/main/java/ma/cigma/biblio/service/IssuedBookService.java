package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.IssuedBook;

import java.util.List;

public interface IssuedBookService {

    public List<IssuedBook> getAll();

    public IssuedBook get(Long id);

    public Long getCountByBook(Book book);

    public IssuedBook save(IssuedBook issuedBook);

    public IssuedBook addNew(IssuedBook issuedBook);
}
