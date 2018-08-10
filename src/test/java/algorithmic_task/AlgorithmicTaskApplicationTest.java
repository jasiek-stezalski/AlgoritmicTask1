package algorithmic_task;

import algorithmic_task.controller.SimilarityController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jstezalski on 08/08/2018.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmicTaskApplicationTest {

    @Autowired
    private SimilarityController controller;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(controller).isNotNull();
    }


}
