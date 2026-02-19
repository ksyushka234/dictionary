package dictionary.db.repository;

import dictionary.db.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import dictionary.db.entity.DictionaryType;

public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Long> {
    DictionaryEntity findByType(DictionaryType type);
}