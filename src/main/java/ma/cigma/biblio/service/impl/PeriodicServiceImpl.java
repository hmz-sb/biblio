package ma.cigma.biblio.service.impl;

import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.entities.Periodic;
import ma.cigma.biblio.mapping.PeriodicMapping;
import ma.cigma.biblio.repository.PeriodicRepository;
import ma.cigma.biblio.service.PeriodicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PeriodicServiceImpl implements PeriodicService {
    @Autowired
    private PeriodicRepository periodicRepository;

    @Autowired
    private PeriodicMapping periodicMapping;


    @Override
    public Long getTotalCount() {
        return periodicRepository.count();
    }

    @Override
    public Long getTotalIssuedPeriodics() {
        return periodicRepository.countByStatus(Constants.BOOK_STATUS_ISSUED);
    }

    @Override
    public List<Periodic> getAll() {
        return periodicRepository.findAll();
    }

    @Override
    public Periodic get(Long id) {
        return periodicRepository.findById(id).get();
    }

    @Override
    public Periodic getByTag(String tag) {
        return periodicRepository.findByTag(tag);
    }

    @Override
    public List<Periodic> get(List<Long> ids) {
        return periodicRepository.findAllById(ids);
    }

    @Override
    public List<Periodic> getByDocument(Document document) {
        return periodicRepository.findByDocument(document);
    }

    @Override
    public List<Periodic> geAvailabletByDocument(Document document) {
        return periodicRepository.findByDocumentAndStatus(document, Constants.BOOK_STATUS_AVAILABLE);
    }

    @Override
    public Periodic addNew(Periodic periodic) {
        periodic.setCreateDate(new Date());
        periodic.setStatus( Constants.BOOK_STATUS_AVAILABLE );
        return periodicRepository.save(periodic);
    }

    @Override
    public Periodic save(Periodic periodic) {
        return periodicRepository.save(periodic);
    }

    @Override
    public void delete(Periodic periodic) {
        periodicRepository.delete(periodic);

    }

    @Override
    public void delete(Long id) {
        periodicRepository.deleteById(id);

    }


}
