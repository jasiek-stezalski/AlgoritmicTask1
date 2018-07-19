package algorithmic_task;

import org.springframework.stereotype.Component;

@Component
public class Task {

    private Long id = 1L;
    private String sentence1;
    private String sentence2;
    private Boolean result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentence1() {
        return sentence1;
    }

    public void setSentence1(String sentence1) {
        this.sentence1 = sentence1;
    }

    public String getSentence2() {
        return sentence2;
    }

    public void setSentence2(String sentence2) {
        this.sentence2 = sentence2;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return !(id != null ? !id.equals(task.id) : task.id != null) && !(sentence1 != null ? !sentence1.equals(task.sentence1) : task.sentence1 != null) && !(sentence2 != null ? !sentence2.equals(task.sentence2) : task.sentence2 != null) && !(result != null ? !result.equals(task.result) : task.result != null);

    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (sentence1 != null ? sentence1.hashCode() : 0);
        result1 = 31 * result1 + (sentence2 != null ? sentence2.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", sentence1='" + sentence1 + '\'' +
                ", sentence2='" + sentence2 + '\'' +
                ", result=" + result +
                '}';
    }
}
