package algorithmic_task.service.Impl;

import algorithmic_task.service.DictionaryService;
import algorithmic_task.service.SimilarityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by jstezalski on 19/07/2018.
 */
@Service
public class SimilarityServiceImpl implements SimilarityService {

    private DictionaryService<Map<String, Integer>> dictionaryService;

    public SimilarityServiceImpl(DictionaryService<Map<String, Integer>> dictionaryService) {
        this.dictionaryService = dictionaryService;
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

        Map<String, Integer> dictionary = dictionaryService.getDictionary();

        for (int i = 0; i < s1.size(); i++)
            /*
              If the word from the sentence isn't in dictionary method should return Integer,
              but if both sentences aren't in dictionary this Integers should be different.
              That is why default values are -1 and -2.
             */
            if (!dictionary.getOrDefault(s1.get(i), -1).equals(dictionary.getOrDefault(s2.get(i), -2)))
                return false;

        return true;
    }

}
