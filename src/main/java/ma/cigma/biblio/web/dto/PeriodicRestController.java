package ma.cigma.biblio.web.dto;


import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.entities.Periodic;
import ma.cigma.biblio.service.DocumentService;
import ma.cigma.biblio.service.PeriodicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PeriodicRestController {

    @Autowired
    private PeriodicService periodicService;
    @Autowired
    private DocumentService documentService;

    @GetMapping(value = {"/", "/list"})
    public List<Periodic> all() {
        return periodicService.getAll();
    }

    @GetMapping(value = "/{id}/list")
    public List<Periodic> get(@PathVariable(name = "id") Long id) {
        Document document = documentService.get(id);
        return periodicService.getByDocument( document );
    }

    @GetMapping(value = "/{id}/available")
    public List<Periodic> getAvailablePeriodics(@PathVariable(name = "id") Long id) {
        Document document = documentService.get(id);
        return periodicService.geAvailabletByDocument( document );
    }
}
