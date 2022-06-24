package ma.cigma.biblio.service.impl;


import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.mapping.BookMapping;
import ma.cigma.biblio.repository.BookRepository;
import ma.cigma.biblio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookMapping bookMapping;
	
	@Autowired
	private IssuedBookServiceImpl issuedBookService;
	
	public Long getTotalCount() {
		return bookRepository.count();
	}
	
	public Long getTotalIssuedBooks() {
		return bookRepository.countByStatus(Constants.BOOK_STATUS_ISSUED);
	}
	
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	public Book get(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public Book getByTag(String tag) {
		return bookRepository.findByTag(tag);
	}
	
	public List<Book> get(List<Long> ids) {
		return bookRepository.findAllById(ids);
	}

	public List<Book> getByDocument(Document document) {return bookRepository.findByDocument(document);
	}

	public List<Book> geAvailabletByDocument(Document document) {
		return bookRepository.findByDocumentAndStatus(document, Constants.BOOK_STATUS_AVAILABLE);
	}
	
	public Book addNew(Book book) {
		book.setCreateDate(new Date());
		book.setStatus( Constants.BOOK_STATUS_AVAILABLE );
		return bookRepository.save(book);
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	public boolean hasUsage(Book book) {
		return issuedBookService.getCountByBook(book)>0;
	}
}
