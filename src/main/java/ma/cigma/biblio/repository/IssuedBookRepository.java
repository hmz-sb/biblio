package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {
     Long countByBookAndReturned(Book book, Integer returned);
}
