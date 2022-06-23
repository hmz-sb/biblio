package ma.cigma.biblio.service.impl;


import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.IssuedBook;
import ma.cigma.biblio.mapping.IssuedBookMapping;
import ma.cigma.biblio.repository.IssuedBookRepository;
import ma.cigma.biblio.service.IssuedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssuedBookServiceImpl implements IssuedBookService {

	@Autowired
	private IssuedBookRepository issuedBookRepository;

	@Autowired
	private IssuedBookMapping issuedBookMapping;
	
	public List<IssuedBook> getAll() {
		return issuedBookRepository.findAll();
	}
	
	public IssuedBook get(Long id) {
		return issuedBookRepository.findById(id).get();
	}
	
	public Long getCountByBook(Book book) {
		return issuedBookRepository.countByBookAndReturned(book, Constants.BOOK_NOT_RETURNED);
	}
	
	public IssuedBook save(IssuedBook issuedBook) {
		return issuedBookRepository.save(issuedBook);
	}
	
	public IssuedBook addNew(IssuedBook issuedBook) {
		issuedBook.setReturned( Constants.BOOK_NOT_RETURNED );
		return issuedBookRepository.save(issuedBook);
	}

}
