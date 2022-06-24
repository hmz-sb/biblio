package ma.cigma.biblio.web;


import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/category")
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String showdocumentsPage(Model model) {
		model.addAttribute("documents", documentService.getAll());
		return "/document/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String adddocumentPage(Model model) {
		model.addAttribute("document", new Document());
		return "/document/form";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editdocumentPage(@PathVariable(name = "id") Long id, Model model) {
		Document document = documentService.get(id);
		if( document != null ) {
			model.addAttribute("document", document);
			return "/document/form";
		} else {
			return "redirect:/document/add";
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savedocument(@Valid Document document, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if( bindingResult.hasErrors() ) {
			return "/category/form";
		}
		
		if( document.getId() == null ) {
			documentService.addNew(document);
			redirectAttributes.addFlashAttribute("successMsg", "'" + document.getName() + "' is added as a new document.");
			return "redirect:/document/add";
		} else {
			Document updateDocument = documentService.save( document );
			redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + document.getName() + "' are saved successfully. ");
			return "redirect:/document/edit/"+updateDocument.getId();
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeDocument(@PathVariable(name = "id") Long id, Model model) {
		Document document = documentService.get( id );
		if( document != null ) {
			if( documentService.hasUsage(document) ) {
				model.addAttribute("documentInUse", true);
				return showdocumentsPage(model);
			} else {
				documentService.delete(id);
			}
		}
		return "redirect:/document/list";
	}
	
}
