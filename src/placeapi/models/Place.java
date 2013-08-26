package placeapi.models;


import placeapi.models.response.ResponseContent;

/**
 * Created by icas on 17/08/13.
 */
public class Place {
    public String id;
    public String name;
    public String cityId;

    public Place() {
    }

    public Place(ResponseContent content) {
        cityId = content.getString("id");
        name = content.getString("name");
        cityId = content.getString("city_id");
    }
}

