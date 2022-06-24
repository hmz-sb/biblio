package ma.cigma.biblio.web.dto;


import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.service.BookService;
import ma.cigma.biblio.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/book")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Book> all() {
		return bookService.getAll();
	}
	
	@GetMapping(value = "/{id}/list")
	public List<Book> get(@PathVariable(name = "id") Long id) {
		Document document = documentService.get(id);
		return bookService.getByDocument( document );
	}
	
	@GetMapping(value = "/{id}/available")
	public List<Book> getAvailableBooks(@PathVariable(name = "id") Long id) {
		Document document = documentService.get(id);
		return bookService.geAvailabletByDocument( document );
	}
	
}
