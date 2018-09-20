package algorithmic_task.service.Impl;

import algorithmic_task.domain.Dictionary;
import algorithmic_task.domain.DictionarySet;
import algorithmic_task.repository.DictionaryRepository;
import algorithmic_task.service.DictionaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by jstezalski on 10/08/2018.
 *
 */
@Component
@Profile("database")
public class DictionaryServiceDbImpl implements DictionaryService<Map<String, Integer>> {

    public static final String DICTIONARY_NAME = "dictionary1";

    private DictionaryRepository dictionaryRepository;

    public DictionaryServiceDbImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void init() {
    }

    /**
     * Method take Dictionary from database and change it to Map of word as a values and index of set as a keys.
     * We can change dictionary by changing DICTIONARY_NAME.
     *
     * @return dictionary in correct form.
     */
    @Override
    public Map<String, Integer> getDictionary() {
        Dictionary dictionary = dictionaryRepository.findByName(DICTIONARY_NAME);

        Map<String, Integer> mapDictionary = new HashMap<>();
        HashSet<String> setOfWords;

        int indexOfSet = 0;

        for (DictionarySet set : dictionary.getDictionarySets()) {
            setOfWords = new HashSet<>(Arrays.asList(set.getContent().split(" ")));

            for (String word : setOfWords) {
                mapDictionary.put(word, indexOfSet);
            }

            indexOfSet++;
        }

        return mapDictionary;
    }

}
