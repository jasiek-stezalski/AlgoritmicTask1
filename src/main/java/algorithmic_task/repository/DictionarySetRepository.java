package algorithmic_task.repository;

import algorithmic_task.domain.DictionarySet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jstezalski on 14/08/2018.
 *
 */
public interface DictionarySetRepository extends JpaRepository<DictionarySet, Long> {
}
