import algorithmic_task.Dictionary;
import algorithmic_task.TaskService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jstezalski on 12/07/2018.
 * */
public class TaskServiceTest {

    private static TaskService taskService;

    @BeforeClass
    public static void beforeClass() {
        taskService = new TaskService(new Dictionary());
    }

    @Test
    public void areSimilar_differentSentences_true() {

        String s1 = "hwefhewf in house";
        String s2 = "mom in home";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_oneWordMultiTime_true() {

        String s1 = "house home home";
        String s2 = "house house house";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_InvertedOrderOfTheSentence_false() {

        String s1 = "mother in house";
        String s2 = "in house mom";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_differentLengthOfSentences_false() {

        String s1 = "mother in house d sf sdfs f";
        String s2 = "in house mom";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySentences_False() {

        String s1 = "";
        String s2 = "";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySpace_False() {

        String s1 = " ";
        String s2 = " ";
        boolean areSimilar = taskService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

}
