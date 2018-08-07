package algorithmic_task;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by jstezalski on 19/07/2018.
 *
 */
@Service
public class SimilarityServiceImpl implements SimilarityService {

    private final Dictionary dictionary;

    public SimilarityServiceImpl(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    /**
     * The method checks if the sentences are similar.
     *
     * @param sentence1 - expect String as a group a words, every word should be in dictionary, shouldn't be null
     * @param sentence2 - expect String as a group a words, every word should be in dictionary, shouldn't be null
     * @return true if corresponding words from sentences are in the same set;
     * false if both sentences are empty String;
     * false otherwise.
     */
    public boolean areSimilar(String sentence1, String sentence2) {
        if (sentence1 == null || sentence2 == null) return false;

        List<String> s1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        List<String> s2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));

        if (s1.size() != s2.size() || s1.size() == 0) return false;

        Map<String, Integer> mapDictionary = new HashMap<>();

        for (int i = 0; i < ((List<Set<String>>) dictionary.getDictionary()).size(); i++) {
            for (String dic : ((List<Set<String>>) dictionary.getDictionary()).get(i)) {
                mapDictionary.put(dic, i);
            }
        }

        for (int i = 0; i < s1.size(); i++)
            if (!mapDictionary.getOrDefault(s1.get(i), -1).equals(mapDictionary.getOrDefault(s2.get(i), -2)))
                return false;

        return true;
    }

}


