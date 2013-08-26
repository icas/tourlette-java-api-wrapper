package placeapi;



import placeapi.models.Request;
import placeapi.models.response.JSONResponse;
import placeapi.models.response.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by icas on 17/08/13.
 */
public class ApiConnection {
    private URL url;
    private String key;
    private String userAgent;
    private DefaultHttpClient client;
    private boolean debug;

    protected ApiConnection() {

    }
    protected ApiConnection(URL apiUrl) {
        this.url = apiUrl;
    }

    public static ApiConnection getConnection() {
        //TODO: Move this to a config file
        URL apiURL = null;
        try{
            apiURL = new URL("http://tourlette-api.herokuapp.com/api/v1/");
        }catch (MalformedURLException e){

        }
        return new ApiConnection(apiURL);

    }

    private DefaultHttpClient getClient() {
        if(client == null) client = new DefaultHttpClient();

        return client;
    }

    public Response performRequest(Request request) {
        String resourceUrl = url+request.getResource();
        HttpResponse response = null;

        try{
            if(request.isGetMethod()){
                HttpGet getRequest = new HttpGet(resourceUrl);
                response = getClient().execute(getRequest);
            }else{
                HttpPost postRequest = new HttpPost(resourceUrl);
                response = client.execute(postRequest);
            }

        }catch (Exception e){
        }



        return new JSONResponse(response);
    }
}

