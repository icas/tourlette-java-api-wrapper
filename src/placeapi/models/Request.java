package placeapi.models;


import java.util.HashMap;

/**
 * Created by icas on 17/08/13.
 */
public class Request {
    private String resource;
    private String verb;
    private HashMap parameters;
    private HashMap requestParameters = new HashMap();

    public Request(Class<? extends PagedResponseContent> resourceClass, String verb, HashMap hashMap) {
        this.resource =  resourceClass.getSimpleName().toLowerCase();
        this.verb = verb; //Validates verbs: GET, POST, PUT, DELETE, SHOW
        this.parameters = parameters;
    }

    public String getResource(){
        return resource;
    }

    public String getMethod(){
        return verb;
    }

    public HashMap getParameters(){
        requestParameters.put("_method", verb);
        return requestParameters;
    }

    public Boolean isGetMethod(){
        return  getAllowedVerb().equals("get");
    }

    public Boolean isPostMethod(){
        return getAllowedVerb().equals("post");
    }


    private String getAllowedVerb(){
        if(verb.equals("get") || verb.equals("show") ){
            return "get";
        }
        else{
            return "post";
        }
    }

}
