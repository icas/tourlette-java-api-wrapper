package placeapi.models.response;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by icas on 19/08/13.
 */
public class JSONResponseContent implements  ResponseContent {
    private Integer currentIndex = 0;
    private JSONArray arrayContent;
    private JSONObject objectContent;

    public JSONResponseContent(Object content){
        if(content instanceof JSONArray){
            arrayContent = (JSONArray)content;
        }else{
            objectContent = (JSONObject)content;
        }

    }

    public JSONResponseContent get(String key){
        JSONResponseContent newContent = null;
        if(!isIterator()){
            try {
                Object keyValue = objectContent.get(key);
                newContent = new JSONResponseContent(objectContent.get(key));

            }
            catch (JSONException e) {

            }
        }

        return newContent;

    }

    public String getString(String key){
        String value = null;
        try {
            value =  objectContent.getString(key);
        }
        catch (JSONException e) {
        }
        return value;
    }

    //This is a Frankenstein model. Some time is iterable some times not
    public boolean isIterator(){
        return arrayContent != null;
    }

    //Iterator methods
    public JSONResponseContent next(){
        JSONResponseContent nextElement = null;
        if(isIterator()){
            if(hasNext()){
                currentIndex++;
                try {
                    nextElement =  new JSONResponseContent(arrayContent.get(currentIndex));
                } catch (JSONException e) {

                }
            }else{
                currentIndex = 0;
                return null;
            }

        }
        return nextElement;
    }
    public void remove(){}

    public boolean hasNext(){
        return currentIndex + 1 < arrayContent.length();
    }
}

