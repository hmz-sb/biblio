package ma.cigma.biblio.web.dto;


import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/category")
public class DocumentRestController {
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Document> all() {
		return documentService.getAll();
	}

}
