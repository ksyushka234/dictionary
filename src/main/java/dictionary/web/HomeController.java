package dictionary.web;

import dictionary.db.repository.DictionaryRepository;
import dictionary.db.repository.EntryRepository;
import dictionary.db.repository.EntryValueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DictionaryRepository dictionaryRepository;
    private final EntryRepository entryRepository;
    private final EntryValueRepository entryValueRepository;

    public HomeController(DictionaryRepository dictionaryRepository,
                          EntryRepository entryRepository,
                          EntryValueRepository entryValueRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.entryRepository = entryRepository;
        this.entryValueRepository = entryValueRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dictionaries")
    public String dictionaries(Model model) {
        model.addAttribute("dictionaries", dictionaryRepository.findAll());
        model.addAttribute("entries", entryRepository.findAll());
        model.addAttribute("values", entryValueRepository.findAll());
        return "dictionaries";
    }
}