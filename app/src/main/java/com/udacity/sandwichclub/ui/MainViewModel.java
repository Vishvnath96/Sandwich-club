package com.udacity.sandwichclub.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.udacity.sandwichclub.R;

public class MainViewModel extends AndroidViewModel {



    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public String[] getSandwiches(){
        return getApplication().getResources().getStringArray(R.array.sandwich_names);
    }

    public void listItemClicked(){

    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }


}
