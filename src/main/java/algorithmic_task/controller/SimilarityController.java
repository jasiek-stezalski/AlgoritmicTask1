package algorithmic_task.controller;

import algorithmic_task.service.SimilarityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jstezalski on 19/07/2018.
 *
 */
@RestController
public class SimilarityController {

    private final SimilarityService similarityService;

    public SimilarityController(SimilarityService similarityService) {
        this.similarityService = similarityService;
    }

    @GetMapping("/")
    public Boolean checkSimilarity(@RequestParam String sentence1, @RequestParam String sentence2) {
        return similarityService.areSimilar(sentence1, sentence2);
    }

}
