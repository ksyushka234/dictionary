package dictionary.db.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entry")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    private DictionaryEntity dictionary;

    @Column(name = "entry_key")
    private String entryKey;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntryValueEntity> values;
    public List<EntryValueEntity> getValues() { return values; }
    public EntryEntity() {
    }

    public EntryEntity(DictionaryEntity dictionary, String entryKey) {
        this.dictionary = dictionary;
        this.entryKey = entryKey;
    }

    public Long getId() {
        return id;
    }

    public DictionaryEntity getDictionary() {
        return dictionary;
    }

    public String getEntryKey() {
        return entryKey;
    }
}