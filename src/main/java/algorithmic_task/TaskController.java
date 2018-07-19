package algorithmic_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public Task task(@RequestParam(value = "sentence1", defaultValue = "") String sentence1,
                        @RequestParam(value = "sentence2", defaultValue = "") String sentence2) {
        return taskService.areSimilar(sentence1, sentence2);
    }

}
