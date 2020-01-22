package tacocloud.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataControllerTest {

    @Autowired
    private WebTestClient testClient;

    @Test
    public void shouldGetReksio(){
        testClient.get().uri("/data/{id}",1)
                .accept(MediaType.APPLICATION_JSON).exchange()
                .expectBody()
                    .jsonPath("name").isEqualTo("Reksio");
    }


}
