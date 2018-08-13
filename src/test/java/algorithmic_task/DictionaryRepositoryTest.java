package algorithmic_task;

import algorithmic_task.domain.Dictionary;
import algorithmic_task.repository.DictionaryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jstezalski on 13/08/2018.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryRepositoryTest {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Test
    public void findByName_WrongDictionaryName_Null() {

        Dictionary dictionary1 = dictionaryRepository.findByName("dictionary3");

        Assert.assertNull(dictionary1);
    }

    @Test
    public void findByName_CorrectDictionaryName() {

        Dictionary dictionary2 = dictionaryRepository.findByName("dictionary1");

        assertEquals("dictionary1", dictionary2.getName());
    }

}
