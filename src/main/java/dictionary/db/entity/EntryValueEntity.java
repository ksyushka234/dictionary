package dictionary.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entry_value")
public class EntryValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private EntryEntity entry;

    @Column(name = "val")
    private String value;

    public EntryValueEntity() {
    }

    public EntryValueEntity(EntryEntity entry, String value) {
        this.entry = entry;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public EntryEntity getEntry() {
        return entry;
    }

    public String getValue() {
        return value;
    }
}