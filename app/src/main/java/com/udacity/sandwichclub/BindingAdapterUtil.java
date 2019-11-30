package com.udacity.sandwichclub;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapterUtil {

    @android.databinding.BindingAdapter(value = {"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.progress_animation)
                .into(view);
    }

}
