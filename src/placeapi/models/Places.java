package placeapi.models;

import placeapi.ApiConnection;
import placeapi.models.response.Response;
import placeapi.models.response.ResponseContent;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by icas on 17/08/13.
 */
public class Places extends PagedResponseContent<Place>{

    public void Places(){

    }
    public ArrayList<Place> get(HashMap parameters){
        ApiConnection connection = ApiConnection.getConnection();
        Request request = new Request(this.getClass(), "get", new HashMap());
        ArrayList places = new ArrayList();
        Response response = connection.performRequest(request);
        ResponseContent content = response.getContent();

        ResponseContent resources = content.get("places"), place = null;
        while(resources.hasNext()){
            ResponseContent cont = resources.next();
            places.add(new Place(cont));
        }
        return places;
    }

    public Place create(Place place){
        return new Place();
    }

    public Place update(Place place){
        return new Place();
    }

    public Place find(String place_id){
        return new Place();
    }

    public void destroy(Place place){
        //return new Place();
    }

}
