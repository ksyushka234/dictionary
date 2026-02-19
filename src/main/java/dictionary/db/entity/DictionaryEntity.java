package dictionary.db.entity;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "dictionary")

public class DictionaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DictionaryType type;

    public DictionaryEntity() {
    }

    public DictionaryEntity(DictionaryType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public DictionaryType getType() {
        return type;
    }
    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntryEntity> entries;
    public List<EntryEntity> getEntries() { return entries; }

}