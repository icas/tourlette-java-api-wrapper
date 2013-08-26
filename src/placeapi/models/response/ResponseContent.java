package placeapi.models.response;

import java.util.Iterator;

/**
 * Created by icas on 19/08/13.
 */
public interface ResponseContent extends Iterator<ResponseContent> {
    public ResponseContent get(String key);
    public String getString(String key);
}

