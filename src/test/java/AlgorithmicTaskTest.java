import algorithmic_task.AlgorithmicTask;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlgorithmicTaskTest {

    private static List<Set<String>> dictionary;
    private static AlgorithmicTask algorithmicTask;


    public AlgorithmicTaskTest() {
    }

    @BeforeClass
    public static void beforeClass() {
        algorithmicTask = new AlgorithmicTask();

        Set<String> set1 = new HashSet<>();
        set1.add("mother");
        set1.add("mom");
        set1.add("mommy");
        set1.add("hwefhewf");

        Set<String> set2 = new HashSet<>();
        set2.add("house");
        set2.add("home");

        Set<String> set3 = new HashSet<>();
        set3.add("in");

        dictionary = new ArrayList<>();
        dictionary.add(set1);
        dictionary.add(set2);
        dictionary.add(set3);
    }

    @Test
    public void areSimilar_differentSentences_true() {

        String s1 = "hwefhewf in house";
        String s2 = "mom in home";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_oneWordMultiTime_true() {

        String s1 = "house home home";
        String s2 = "house house house";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertTrue(areSimilar);
    }

    @Test
    public void areSimilar_InvertedOrderOfTheSentence_false() {

        String s1 = "mother in house";
        String s2 = "in house mom";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_differentLengthOfSentences_false() {

        String s1 = "mother in house d sf sdfs f";
        String s2 = "in house mom";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySentences_False() {

        String s1 = "";
        String s2 = "";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertFalse(areSimilar);
    }

    @Test
    public void areSimilar_emptySpace_False() {

        String s1 = " ";
        String s2 = " ";
        boolean areSimilar = algorithmicTask.areSimilar(dictionary, s1, s2);

        assertFalse(areSimilar);
    }

}
