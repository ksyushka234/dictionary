package dictionary.db.repository;

import dictionary.db.entity.EntryValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryValueRepository extends JpaRepository<EntryValueEntity, Long> {
    List<EntryValueEntity> findByValueContainingIgnoreCase(String value);
}