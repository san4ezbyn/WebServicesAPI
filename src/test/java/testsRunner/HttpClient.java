package testsRunner;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sun.deploy.net.protocol.ProtocolType.HTTP;

public class HttpClient {

    @Test
        public void checkStatusCodeTest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/posts");
        CloseableHttpResponse response = httpclient.execute(httpGet);

        System.out.println("response "+response);

        int statusCodeAct = response.getStatusLine().getStatusCode();
           System.out.println("statusCodeAct " + statusCodeAct);
        Assert.assertEquals(statusCodeAct, 200);

    }

    @Test
    public void checkResponseContentTest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://jsonplaceholder.typicode.com/posts");
        CloseableHttpResponse response = httpclient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        System.out.println( "entity.getContent " + entity.getContent());


    }
}
