package algorithmic_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by jstezalski on 19/07/2018.
 * */
@Service
public class TaskService {

    private final Dictionary dictionary;

    @Autowired
    public TaskService(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * The method checks if the sentences are similar.
     *
     * @return true if corresponding words from sentences are in the same set;
     *         false otherwise.
     * */
    public boolean areSimilar(String sentence1, String sentence2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        List<String> s2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));

        if (s1.size() != s2.size() || s1.size() == 0) return false;

        Map<String, Integer> mapDictionary = new HashMap<>();

        for (int i = 0; i < dictionary.getDictionary().size(); i++) {
            for (String dic : dictionary.getDictionary().get(i)) {
                mapDictionary.put(dic, i);
            }
        }

        for (int i = 0; i < s1.size(); i++)
            if (!mapDictionary.getOrDefault(s1.get(i), -1).equals(mapDictionary.getOrDefault(s2.get(i), -2)))
                return false;

        return true;
    }

}


