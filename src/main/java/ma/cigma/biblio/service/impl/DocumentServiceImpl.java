package ma.cigma.biblio.service.impl;


import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.mapping.DocumentMapping;
import ma.cigma.biblio.repository.DocumentRepository;
import ma.cigma.biblio.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private DocumentMapping documentMapping;

	
	public Long getTotalCount() {
		return documentRepository.count();
	}
	
	public List<Document> getAllBySort() {
		return documentRepository.findAllByOrderByNameAsc();
	}
	
	public List<Document> getAll() {
		return documentRepository.findAll();
	}
	
	public Document get(Long id) {
		return documentRepository.findById(id).get();
	}
	
	public Document addNew(Document document) {
		document.setCreateDate(new Date());
		return documentRepository.save(document);
	}
	
	public Document save(Document document) {
		return documentRepository.save(document);
	}
	
	public void delete(Document document) {
		documentRepository.delete(document);
	}
	
	public void delete(Long id) {
		documentRepository.deleteById(id);
	}
	
	public boolean hasUsage(Document document) {
		return document.getBooks().size()>0;
	}
}
