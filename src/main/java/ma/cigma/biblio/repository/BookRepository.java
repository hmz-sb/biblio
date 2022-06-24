package ma.cigma.biblio.repository;


import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
     Book findByTag(String tag);
     List<Book> findByDocument(Document document);
     List<Book> findByDocumentAndStatus(Document document, Integer status);
     Long countByStatus(Integer status);
     List<Book> findBookByName(Book Title);
     List<Book> findBookByAuteur(Book authors);
     List<Book> findBookByNameAndAuteur (Book Title,Book authors);
}
