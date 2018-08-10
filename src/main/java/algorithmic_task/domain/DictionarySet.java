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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionarySet that = (DictionarySet) o;

        return !(id != null ? !id.equals(that.id) : that.id != null) && !(content != null ? !content.equals(that.content) : that.content != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DictionarySet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

}
