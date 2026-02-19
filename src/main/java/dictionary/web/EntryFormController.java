package dictionary.web;

import dictionary.db.entity.DictionaryEntity;
import dictionary.db.entity.DictionaryType;
import dictionary.db.entity.EntryEntity;
import dictionary.db.entity.EntryValueEntity;
import dictionary.db.repository.DictionaryRepository;
import dictionary.db.repository.EntryRepository;
import dictionary.db.repository.EntryValueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EntryFormController {

    private final DictionaryRepository dictionaryRepository;
    private final EntryRepository entryRepository;
    private final EntryValueRepository entryValueRepository;

    public EntryFormController(DictionaryRepository dictionaryRepository,
                               EntryRepository entryRepository,
                               EntryValueRepository entryValueRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.entryRepository = entryRepository;
        this.entryValueRepository = entryValueRepository;
    }

    @GetMapping("/entries/new")
    public String newEntryForm() {
        return "entry-form";
    }

    @PostMapping("/entries")
    public String createEntry(@RequestParam DictionaryType type,
                              @RequestParam String key,
                              @RequestParam(name = "values") List<String> values) {

        DictionaryEntity dictionary = dictionaryRepository.findByType(type);
        if (dictionary == null) {
            dictionary = dictionaryRepository.save(new DictionaryEntity(type));
        }

        EntryEntity entry = entryRepository.save(new EntryEntity(dictionary, key));

        for (String v : values) {
            if (v != null && !v.isBlank()) {
                entryValueRepository.save(new EntryValueEntity(entry, v));
            }
        }

        return "redirect:/dictionaries";
    }
}