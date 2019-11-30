package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            if(jsonObject.getString("name") != null){
                JSONObject name = new JSONObject(jsonObject.getString("name"));
                sandwich.setMainName(name.getString("mainName"));
                if(name.getString("alsoKnownAs") != null){
                    JSONArray array = new JSONArray(name.getString("alsoKnownAs"));
                    List<String> list = getStrings(array);
                    sandwich.setAlsoKnownAs(list);                }
            }
            if(jsonObject.getString("placeOfOrigin") != null){
                sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            }
            if(jsonObject.getString("description") != null){
                sandwich.setDescription(jsonObject.getString("description"));
            }
            if(jsonObject.getString("image") != null){
                sandwich.setImage(jsonObject.getString("image"));
            }
            if(jsonObject.getString("ingredients") != null){
                JSONArray jsonArray = new JSONArray(jsonObject.getString("ingredients"));
                List<String> list = getStrings(jsonArray);
                sandwich.setIngredients(list);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }

    private static List<String> getStrings(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for(int i = 0;i<jsonArray.length();i++){
            list.add(jsonArray.getString(i));
        }
        return list;
    }

}
