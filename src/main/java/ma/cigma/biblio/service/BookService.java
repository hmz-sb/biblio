package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Document;

import java.util.List;

public interface BookService {
    public Long getTotalCount();

    public Long getTotalIssuedBooks();

    public List<Book> getAll();

    public Book get(Long id);

    public Book getByTag(String tag);

    public List<Book> get(List<Long> ids);

    public List<Book> getByDocument(Document document);

    public List<Book> geAvailabletByDocument(Document document);

    public Book addNew(Book book) ;

    public Book save(Book book);

    public void delete(Book book);

    public void delete(Long id);

    public boolean hasUsage(Book book);
}
