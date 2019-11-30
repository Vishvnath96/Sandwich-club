package com.udacity.sandwichclub.ui;

import android.arch.lifecycle.ViewModel;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class DetailViewModel extends ViewModel {
    private String sandWichData;
    private Sandwich sandwich;
    private static final String UNKNOWN = "Unknown";

    DetailViewModel(String sandWichData) {
        this.sandWichData = sandWichData;
        parseSandwichJson();
    }

    private void parseSandwichJson() {
        sandwich = JsonUtils.parseSandwichJson(sandWichData);
    }

    public String mainName(){
        return sandwich.getMainName();
    }

    public String alsoKnownAs(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str: sandwich.getAlsoKnownAs()){
            stringBuilder.append(" ").append(str).append(" ");
        }
        return stringBuilder.toString().isEmpty() ? UNKNOWN : stringBuilder.toString();
    }

    public String getPlaceOfOrigin(){
        if(sandwich.getPlaceOfOrigin() == null || sandwich.getPlaceOfOrigin().isEmpty()){
            return UNKNOWN;
        }
         return sandwich.getPlaceOfOrigin();
    }

    public String getDescription(){
         return sandwich.getDescription();
    }

    public String getImageUrl(){
        return sandwich.getImage();
    }

    public String ingredients(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str: sandwich.getIngredients()){
            stringBuilder.append(str).append(",").append("\n");
        }
        return stringBuilder.toString().isEmpty() ? UNKNOWN : stringBuilder.toString();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


}
