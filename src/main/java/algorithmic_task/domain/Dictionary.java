package algorithmic_task.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jstezalski on 10/08/2018.
 *
 */
@Entity
@Table(name = "dictionary")
public class Dictionary {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DictionarySet> dictionarySets;

    public Dictionary() {
    }

    public Dictionary(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DictionarySet> getDictionarySets() {
        return dictionarySets;
    }

    public void setDictionarySets(List<DictionarySet> dictionarySets) {
        this.dictionarySets = dictionarySets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;

        return !(id != null ? !id.equals(that.id) : that.id != null) && !(name != null ? !name.equals(that.name) : that.name != null) && !(dictionarySets != null ? !dictionarySets.equals(that.dictionarySets) : that.dictionarySets != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dictionarySets != null ? dictionarySets.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dictionarySets=" + dictionarySets +
                '}';
    }
}
