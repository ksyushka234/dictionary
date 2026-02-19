package dictionary.db.repository;

import dictionary.db.entity.EntryValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryValueRepository extends JpaRepository<EntryValueEntity, Long> {
}