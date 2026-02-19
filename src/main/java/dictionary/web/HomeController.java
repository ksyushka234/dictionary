package dictionary.web;

import dictionary.db.entity.DictionaryType;
import dictionary.db.repository.DictionaryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DictionaryRepository dictionaryRepository;

    public HomeController(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dictionaries")
    public String dictionaries(Model model) {
        model.addAttribute("latinDictionary",
                dictionaryRepository.findByType(DictionaryType.LATIN));
        model.addAttribute("digitDictionary",
                dictionaryRepository.findByType(DictionaryType.DIGIT));
        return "dictionaries";
    }
}