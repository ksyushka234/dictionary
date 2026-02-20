package dictionary.web;

import dictionary.db.entity.DictionaryType;
import dictionary.db.entity.EntryEntity;
import dictionary.db.entity.EntryValueEntity;
import dictionary.db.repository.EntryRepository;
import dictionary.db.repository.EntryValueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private final EntryRepository entryRepository;
    private final EntryValueRepository entryValueRepository;

    public SearchController(EntryRepository entryRepository, EntryValueRepository entryValueRepository) {
        this.entryRepository = entryRepository;
        this.entryValueRepository = entryValueRepository;
    }

    @GetMapping("/search")
    public String search(@RequestParam String q,
                         @RequestParam(defaultValue = "ALL") String scope,
                         @RequestParam(defaultValue = "KEY") String by,
                         Model model) {

        List<EntryEntity> result = new ArrayList<>();

        if ("KEY".equalsIgnoreCase(by)) {
            result = entryRepository.findByEntryKeyContainingIgnoreCase(q);
        } else if ("VALUE".equalsIgnoreCase(by)) {
            List<EntryValueEntity> values = entryValueRepository.findByValueContainingIgnoreCase(q);
            for (EntryValueEntity v : values) {
                result.add(v.getEntry());
            }
        }

        // фильтр по словарю
        if (!"ALL".equalsIgnoreCase(scope)) {
            DictionaryType type = DictionaryType.valueOf(scope.toUpperCase());
            result.removeIf(e -> e.getDictionary() == null || e.getDictionary().getType() != type);
        }

        model.addAttribute("q", q);
        model.addAttribute("result", result);
        model.addAttribute("scope", scope);
        model.addAttribute("by", by);
        return "search";
    }
}