package algorithmic_task.service.Impl;

import algorithmic_task.domain.Dictionary;
import algorithmic_task.domain.DictionarySet;
import algorithmic_task.repository.DictionaryRepository;
import algorithmic_task.service.DictionaryService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;



/**
 * Created by jstezalski on 10/08/2018.
 */
@Component
@Primary
public class DictionaryServiceDbImpl implements DictionaryService<List<Set<String>>> {

    public static final String DICTIONARY_NAME = "dictionary1";

    private DictionaryRepository dictionaryRepository;

    public DictionaryServiceDbImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void init() {
    }

    /**
     * Method take Dictionary from database and change it to List of Set of Strings.
     * We can change dictionary by changing DICTIONARY_NAME.
     * @return dictionary in correct form.
     */
    @Override
    public List<Set<String>> getDictionary() {
        Dictionary dictionary = dictionaryRepository.findByName(DICTIONARY_NAME);

        List<Set<String>> newDictionary = new ArrayList<>();

        for (DictionarySet set : dictionary.getDictionarySets()) {
            List<String> s1 = new ArrayList<>(Arrays.asList(set.getContent().split(" ")));
            Set<String> set1 = new HashSet<>(s1);
            newDictionary.add(set1);
        }

        return newDictionary;
    }

}
