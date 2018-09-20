package algorithmic_task;

import algorithmic_task.controller.SimilarityController;
import algorithmic_task.service.SimilarityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jstezalski on 08/08/2018.
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SimilarityController.class)
public class SimilarityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SimilarityService service;

    @Test
    public void areSimilar_OneTheSameWord_True() throws Exception {
        when(service.areSimilar("mom", "mom")).thenReturn(true);

        this.mockMvc.perform(get("/?sentence1=mom&sentence2=mom"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

    }

    @Test
    public void areSimilar_EmptySentences_False() throws Exception {
        when(service.areSimilar("", "")).thenReturn(false);

        this.mockMvc.perform(get("/?sentence1=&sentence2="))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));

    }

    @Test
    public void areSimilar_LongSentences_True() throws Exception {
        when(service.areSimilar("mother in house hwefhewf", "mom in house mother")).thenReturn(true);

        this.mockMvc.perform(get("/?sentence1=mother in house hwefhewf&sentence2=mom in house mother"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

    }

}
