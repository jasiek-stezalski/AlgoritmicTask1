package algorithmic_task.domain;

import javax.persistence.*;

/**
 * Created by jstezalski on 10/08/2018.
 *
 */
@Entity
@Table(name = "dictionary_set")
public class DictionarySet {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "ID_DICTIONARY")
    private Dictionary dictionary;

    public DictionarySet() {
    }

    public DictionarySet(Long id, String content, Dictionary dictionary) {
        this.id = id;
        this.content = content;
        this.dictionary = dictionary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionarySet that = (DictionarySet) o;

        return !(id != null ? !id.equals(that.id) : that.id != null) && !(content != null ? !content.equals(that.content) : that.content != null) && !(dictionary != null ? !dictionary.equals(that.dictionary) : that.dictionary != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (dictionary != null ? dictionary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DictionarySet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", dictionary=" + dictionary +
                '}';
    }

}
