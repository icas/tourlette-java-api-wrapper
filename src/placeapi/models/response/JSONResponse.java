package placeapi.models.response;

import org.apache.http.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by icas on 19/08/13.
 */
public class JSONResponse implements Response {
    public JSONResponseContent content;
    //Attributes pending to be defined: HEADERS

    public JSONResponse(HttpResponse response) {
        content = new JSONResponseContent(parseResponseContent(response));
    }

    public JSONResponseContent getContent(){
        return content;
    }

    private JSONObject parseResponseContent(HttpResponse response){
        JSONObject jObject = null;

        try{
            StringBuilder responseStringBuilder = new StringBuilder();
            String line = "";
            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            while ((line = rd.readLine()) != null) responseStringBuilder.append(line + "\n");

            try{
                jObject = new JSONObject(responseStringBuilder.toString());
            }catch (JSONException e){
            }

        }catch (IOException e){
        }

        return jObject;
    }


}
