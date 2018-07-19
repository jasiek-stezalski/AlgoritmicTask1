package algorithmic_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private Task task;
    private List<Set<String>> dictionary;

    @Autowired
    public TaskService(Task task) {
        this.task = task;

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();

        set1.add("mother");
        set1.add("mom");
        set1.add("hwefhewf");

        set2.add("house");
        set2.add("home");

        set3.add("in");

        dictionary = new ArrayList<>();

        dictionary.add(set1);
        dictionary.add(set2);
        dictionary.add(set3);

    }


    public Task areSimilar(String sentence1, String sentence2) {
        task.setSentence1(sentence1);
        task.setSentence2(sentence2);
        task.setResult(false);

        List<String> s1 = new ArrayList<>(Arrays.asList(sentence1.split(" ")));
        List<String> s2 = new ArrayList<>(Arrays.asList(sentence2.split(" ")));


        if (s1.size() != s2.size() || s1.size() == 0) return task;

        Map<String, Integer> mapDictionary = new HashMap<>();

        for (int i = 0; i < dictionary.size(); i++) {
            for (String dic : dictionary.get(i)) {
                mapDictionary.put(dic, i);
            }
        }

        for (int i = 0; i < s1.size(); i++)
            if (!mapDictionary.getOrDefault(s1.get(i), -1).equals(mapDictionary.getOrDefault(s2.get(i), -2)))
                return task;

        task.setResult(true);
        return task;
    }

}


