package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.entities.Periodic;

import java.util.List;

public interface PeriodicService {
    public Long getTotalCount();

    public Long getTotalIssuedPeriodics();

    public List<Periodic> getAll();

    public Periodic get(Long id);

    public Periodic getByTag(String tag);

    public List<Periodic> get(List<Long> ids);

    public List<Periodic> getByDocument(Document document);

    public List<Periodic> geAvailabletByDocument(Document document);

    public Periodic addNew(Periodic periodic) ;

    public Periodic save(Periodic periodic);

    public void delete(Periodic periodic);

    public void delete(Long id);

}
