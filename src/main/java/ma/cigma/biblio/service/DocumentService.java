package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.Document;

import java.util.List;

public interface DocumentService {
    public Long getTotalCount();

    public List<Document> getAllBySort();

    public List<Document> getAll();

    public Document get(Long id);

    public Document addNew(Document document);

    public Document save(Document document);

    public void delete(Document document);

    public void delete(Long id);

    public boolean hasUsage(Document document);
}
