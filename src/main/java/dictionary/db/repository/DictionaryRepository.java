package dictionary.db.repository;

import dictionary.db.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Long> {
}