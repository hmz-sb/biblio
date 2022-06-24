package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.entities.Periodic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodicRepository extends JpaRepository<Periodic, Long> {

    Periodic findByTag(String tag);
    List<Periodic> findByDocument(Document document);
    List<Periodic> findByDocumentAndStatus(Document document, Integer status);
    Long countByStatus(Integer status);
    List<Periodic> findByname (Periodic Title);
    List<Periodic> findbydate (Periodic publishedDate);
    List<Periodic> findByNameAndDate (Periodic Title,Periodic publishedDate);

}
