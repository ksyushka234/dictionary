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
    public CommandLineRunner demoRunner(DictionaryRepository dictionaryRepository,
                                        EntryRepository entryRepository,
                                        EntryValueRepository entryValueRepository) {
        return args -> {
            DictionaryEntity latin = dictionaryRepository.findByType(DictionaryType.LATIN);
            if (latin == null) {
                latin = dictionaryRepository.save(new DictionaryEntity(DictionaryType.LATIN));
            }

            DictionaryEntity digit = dictionaryRepository.findByType(DictionaryType.DIGIT);
            if (digit == null) {
                digit = dictionaryRepository.save(new DictionaryEntity(DictionaryType.DIGIT));
            }

            if (entryRepository.findByDictionaryAndEntryKey(latin, "word").isEmpty()) {
                EntryEntity entry = entryRepository.save(new EntryEntity(latin, "word"));
                entryValueRepository.save(new EntryValueEntity(entry, "слово"));
                entryValueRepository.save(new EntryValueEntity(entry, "термин"));
            }

            System.out.println("DB init done");
        };
    }
}
