package ma.cigma.biblio.web;

import ma.cigma.biblio.entities.Document;
import ma.cigma.biblio.entities.Periodic;
import ma.cigma.biblio.service.DocumentService;
import ma.cigma.biblio.service.PeriodicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/periodic")
public class PeriodicContoller {

    @Autowired
    private PeriodicService periodicService;

    @Autowired
    private DocumentService documentService;

    @ModelAttribute(name = "documents")
    public List<Document> documents() {
        return documentService.getAllBySort();
    }

    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String showPeriodicsPage(Model model) {
        model.addAttribute("books", periodicService.getAll());
        return "/periodic/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPeriodicPage(Model model) {
        model.addAttribute("periodic", new Periodic());
        return "/periodic/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPeriodicPage(@PathVariable(name = "id") Long id, Model model) {
        Periodic periodic = periodicService.get(id);
        if( periodic != null ) {
            model.addAttribute("periodic", periodic);
            return "/periodic/form";
        } else {
            return "redirect:/periodic/add";
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePeriodic(@Valid Periodic periodic, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            return "/periodic/form";
        }

        if( periodic.getId() == null ) {
            if( periodicService.getByTag(periodic.getTag()) != null ) {
                bindingResult.rejectValue("tag", "tag", "Tag already exists");
                return "/periodic/form";
            } else {
                periodicService.addNew(periodic);
                redirectAttributes.addFlashAttribute("successMsg", "'" + periodic.getTitle() + "' is added as a new periodic.");
                return "redirect:/periodic/add";
            }
        } else {
            Periodic updatedPeriodic = periodicService.save(periodic);
            redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + periodic.getTitle() + "' are saved successfully. ");
            return "redirect:/periodic/edit/"+updatedPeriodic.getId();
        }
    }

}
