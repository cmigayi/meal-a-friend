package Http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HandleJsonDataFromServer {

    JSONObject jsonObject;
    JSONArray dataFromServerJsonArray;
    ArrayList<HashMap<String,String>> dataFromServerArraylist;

    public JSONArray getJsonArray() throws JSONException {

        if(jsonObject.length() == 0){
            dataFromServerArraylist = null;
        }

        dataFromServerJsonArray = jsonObject.getJSONArray("content");

        //JSONObject dataItem = dataFromServerJsonArray.getJSONObject(0);

        return dataFromServerJsonArray;
    }

//    public boolean checkStatus() throws JSONException {
//        JSONObject dataItem = jsonArray.getJSONObject(0);
//        boolean status = dataItem.getBoolean("status");
//
//        return status;
//    }
}
