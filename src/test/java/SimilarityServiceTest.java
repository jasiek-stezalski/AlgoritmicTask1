import algorithmic_task.Dictionary;
import algorithmic_task.DictionaryImpl;
import algorithmic_task.SimilarityServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jstezalski on 12/07/2018.
 *
 */
public class SimilarityServiceTest {

    private SimilarityServiceImpl similarityService;

    @Before
    public void before() {
        Dictionary dictionary = new DictionaryImpl();
        dictionary.init();
        similarityService = new SimilarityServiceImpl(dictionary);
    }

    @Test
    public void areSimilar_differentSentences_true() {

        String s1 = "hwefhewf in house";
        String s2 = "mom in home";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_oneWordMultiTime_true() {

        String s1 = "house home home";
        String s2 = "house house house";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_InvertedOrderOfTheSentence_false() {

        String s1 = "mother in house";
        String s2 = "in house mom";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_differentLengthOfSentences_false() {

        String s1 = "mother in house d sf sdfs f";
        String s2 = "in house mom";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySentences_False() {

        String s1 = "";
        String s2 = "";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySpace_False() {

        String s1 = " ";
        String s2 = " ";
        boolean areSimilar = similarityService.areSimilar(s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_nullAsOneSentence_False() {

        String s = "in house mom";
        boolean areSimilar = similarityService.areSimilar(null, s);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_nullAsTwoSentence_False() {

        boolean areSimilar = similarityService.areSimilar(null, null);

        assertFalse(areSimilar);
    }

}
