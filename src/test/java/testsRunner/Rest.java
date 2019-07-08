package testsRunner;

import com.post.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Rest {

    @Test
    public void checkStatusCode() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<Post[]> response = restTeampl.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        int actualStatusCode = response.getStatusCodeValue();
        Assert.assertEquals(actualStatusCode, 200);
    }
@Test
    public void checkResponseHeader() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<Post[]> response = restTeampl.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);

        List<String> valueOfContentTypeHeader = response.getHeaders().get("content-type");
        Assert.assertTrue(valueOfContentTypeHeader.get(0).contains("application/json"));
    }

    @Test(enabled = true)
    public void checkResponseBody() {
        RestTemplate restTeampl = new RestTemplate();
        ResponseEntity<Post[]> response = restTeampl.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        Assert.assertEquals(response.getBody().length, 100);
    }

}
