package dictionary;

import dictionary.db.entity.EntryEntity;
import dictionary.db.entity.EntryValueEntity;
import dictionary.db.repository.EntryRepository;
import dictionary.db.repository.EntryValueRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dictionary.db.entity.DictionaryEntity;
import dictionary.db.entity.DictionaryType;
import dictionary.db.repository.DictionaryRepository;
@SpringBootApplication
public class DictionaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
    }
    @Bean
    public CommandLineRunner demoRunner(DictionaryRepository dictionaryRepository, EntryRepository entryRepository, EntryValueRepository entryValueRepository) {
        return args -> {
            if (dictionaryRepository.count() > 0) {
                return;
            }
            DictionaryEntity latin = new DictionaryEntity(DictionaryType.LATIN);
            DictionaryEntity digit = new DictionaryEntity(DictionaryType.DIGIT);
            dictionaryRepository.save(latin);
            dictionaryRepository.save(digit);
            System.out.println("Entry and values saved");
            EntryEntity entry = new EntryEntity(latin, "word");
            entryRepository.save(entry);

            entryValueRepository.save(new EntryValueEntity(entry, "слово"));
            entryValueRepository.save(new EntryValueEntity(entry, "термин"));
            System.out.println("Dictionaries saved");
            System.out.println("DB init runner started");
        };

    }
}
