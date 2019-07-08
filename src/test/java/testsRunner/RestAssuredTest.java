package testsRunner;

import com.post.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RestAssuredTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response response = given().get("/posts").andReturn();
        System.out.println("body " + response.body().prettyPrint());
        System.out.println("HIDER " + response.getHeaders());
        int actualStatusCode = response.getStatusCode();
        System.out.println("code " + actualStatusCode + " \nresponse " + response);
        Assert.assertEquals(actualStatusCode, 200);
        System.out.println("VSE -" + response.getHeaders());
    }

    @Test
    public void checkResponseHeader() {
        Response response = given().get("/posts").andReturn();
        String valueOfContentTypeHeader = response.getHeader("content-type");
        System.out.println("Header " + valueOfContentTypeHeader);
        Assert.assertTrue(valueOfContentTypeHeader.contains("application/json"));
        Assert.assertTrue(valueOfContentTypeHeader.contains("charset=utf-8"));
    }

    @Test
    public void checkResponseBody() {
        Response response = given().get("/posts").andReturn();
        Post[] posts = response.as(Post[].class);
        System.out.println("posts " + posts);
        Assert.assertEquals(posts.length, 100);
    }
    private String string;
    @Test
    public void checkResponseBodyUser() {
       Response response = given().get("/posts").andReturn();
     Post[] posts = response.as(Post[].class);
        Post post = new Post();
        //System.out.println(response.asString());
        System.out.println(response.body().peek());
        // System.out.println("users "+ get().body().prettyPrint());
        // Assert.assertEquals(posts.length, 100);


    }
}
