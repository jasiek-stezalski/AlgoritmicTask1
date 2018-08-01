package algorithmic_task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by jstezalski on 20/07/2018.
 * */
@Component
public class DictionaryImpl implements Dictionary<List<Set<String>>> {

    /**
     * Dictionary is represented as List of Sets.
     * Inside every set are words considered to be similar.
     * Each word can be only inside one set.
     */
    private List<Set<String>> dictionary;

    @Override
    @PostConstruct
    public void init() {
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

        dictionary.add(Collections.unmodifiableSet(set1));
        dictionary.add(Collections.unmodifiableSet(set2));
        dictionary.add(Collections.unmodifiableSet(set3));
    }

    @Override
    public List<Set<String>> getDictionary() {
        return Collections.unmodifiableList(dictionary);
    }

}
