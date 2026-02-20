package dictionary.web;

import dictionary.db.entity.EntryEntity;
import dictionary.db.entity.EntryValueEntity;
import dictionary.db.repository.EntryRepository;
import dictionary.db.repository.EntryValueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EntryEditController {

    private final EntryRepository entryRepository;
    private final EntryValueRepository entryValueRepository;

    public EntryEditController(EntryRepository entryRepository, EntryValueRepository entryValueRepository) {
        this.entryRepository = entryRepository;
        this.entryValueRepository = entryValueRepository;
    }

    @GetMapping("/entries/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        EntryEntity entry = entryRepository.findById(id).orElse(null);
        if (entry == null) {
            return "redirect:/dictionaries";
        }
        model.addAttribute("entry", entry);
        return "entry-edit";
    }

    @PostMapping("/entries/{id}/values")
    public String addValue(@PathVariable Long id, @RequestParam String value) {
        EntryEntity entry = entryRepository.findById(id).orElse(null);
        if (entry == null) {
            return "redirect:/dictionaries";
        }
        if (value != null && !value.isBlank()) {
            entryValueRepository.save(new EntryValueEntity(entry, value));
        }
        return "redirect:/entries/" + id + "/edit";
    }

    @PostMapping("/values/{valueId}/delete")
    public String deleteValue(@PathVariable Long valueId, @RequestParam Long entryId) {
        entryValueRepository.deleteById(valueId);
        return "redirect:/entries/" + entryId + "/edit";
    }
}