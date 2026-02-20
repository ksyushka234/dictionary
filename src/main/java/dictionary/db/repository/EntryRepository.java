package dictionary.db.repository;

import dictionary.db.entity.DictionaryEntity;
import dictionary.db.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends JpaRepository<EntryEntity, Long> {
    Optional<EntryEntity> findByDictionaryAndEntryKey(DictionaryEntity dictionary, String entryKey);
    List<EntryEntity> findByEntryKeyContainingIgnoreCase(String entryKey);
}