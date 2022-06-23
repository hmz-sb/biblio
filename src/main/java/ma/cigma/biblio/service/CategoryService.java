package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.Category;

import java.util.Date;
import java.util.List;

public interface CategoryService {
    public Long getTotalCount();

    public List<Category> getAllBySort();

    public List<Category> getAll();

    public Category get(Long id);

    public Category addNew(Category category);

    public Category save(Category category);

    public void delete(Category category);

    public void delete(Long id);

    public boolean hasUsage(Category category);
}
