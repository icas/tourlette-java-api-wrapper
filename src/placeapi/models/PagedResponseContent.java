package placeapi.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by icas on 17/08/13.
 */
public class PagedResponseContent<T> implements Iterable<T> {
    ArrayList<T> contents;


    public Iterator<T> iterator() {
        if(contents == null) {
            List<T> emptyList = Collections.emptyList();
            return emptyList.iterator();
        }
        return contents.iterator();
    }
}

