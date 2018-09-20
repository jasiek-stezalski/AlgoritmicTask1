package algorithmic_task;

import algorithmic_task.domain.Dictionary;
import algorithmic_task.domain.DictionarySet;
import algorithmic_task.repository.DictionaryRepository;
import algorithmic_task.repository.DictionarySetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jstezalski on 13/08/2018.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryRepositoryTest {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private DictionarySetRepository dictionarySetRepository;

    @Before
    public void before() {
        dictionaryRepository.deleteAll();
    }

    @Test
    public void whenFindAll_thenReturnEmptyListOfDictionaries() {

        List<Dictionary> dictionaries = dictionaryRepository.findAll();

        assertEquals(0, dictionaries.size());

    }

    @Test
    public void whenFindAll_thenReturnEmptyListDictionarySets() {

        List<DictionarySet> dictionarySets = dictionarySetRepository.findAll();

        assertEquals(0, dictionarySets.size());

    }

    @Test
    public void whenFindByName_thenReturnDictionary() {

        dictionaryRepository.save(new Dictionary(1L, "dictionary1"));

        Dictionary dictionary = dictionaryRepository.findByName("dictionary1");

        assertEquals("dictionary1", dictionary.getName());

    }

    @Test
    public void whenFindByName_thenReturnDictionaryWithDictionarySets() {

        Dictionary dictionary = dictionaryRepository.save(new Dictionary(1L, "dictionary1"));
        dictionarySetRepository.save(new DictionarySet(1L, "simple sentence1", dictionary));
        dictionarySetRepository.save(new DictionarySet(2L, "simple sentence2", dictionary));

        Dictionary newDictionary = dictionaryRepository.findByName("dictionary1");

        assertEquals("simple sentence2", newDictionary.getDictionarySets().get(1).getContent());

    }

}
