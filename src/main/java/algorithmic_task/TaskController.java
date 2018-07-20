package algorithmic_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jstezalski on 19/07/2018.
 * */
@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public boolean task(@RequestParam(value = "sentence1", defaultValue = "") String sentence1,
                        @RequestParam(value = "sentence2", defaultValue = "") String sentence2) {
        return taskService.areSimilar(sentence1, sentence2);
    }

}
