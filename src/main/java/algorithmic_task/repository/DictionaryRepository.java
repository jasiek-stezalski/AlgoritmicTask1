package algorithmic_task.repository;

import algorithmic_task.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jstezalski on 10/08/2018.
 */
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

    Dictionary findByName(String name);

}
