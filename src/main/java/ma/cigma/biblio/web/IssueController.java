package ma.cigma.biblio.web;


import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.service.DocumentService;
import ma.cigma.biblio.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

	@Autowired
	private IssueService issueService;
	
	@Autowired
	private DocumentService documentService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	@ModelAttribute("documents")
	public List<Document> getDocuments() {
		return documentService.getAllBySort();
	}
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listIssuePage(Model model) {
		model.addAttribute("issues", issueService.getAllUnreturned());
		return "/issue/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newIssuePage(Model model) { 
		return "/issue/form";
	}
	
}
