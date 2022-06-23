package ma.cigma.biblio.repository;


import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
     Book findByTag(String tag);
     List<Book> findByCategory(Category category);
     List<Book> findByCategoryAndStatus(Category category, Integer status);
     Long countByStatus(Integer status);
}
