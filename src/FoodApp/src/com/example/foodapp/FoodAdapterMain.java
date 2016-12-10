package com.example.foodapp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodAdapterMain extends ArrayAdapter<Food>{

	private int resourceId;
	
	public FoodAdapterMain(Context context, int resource, List<Food> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Food food = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView foodImage = (ImageView) view.findViewById(R.id.food_image1);
		TextView foodName = (TextView) view.findViewById(R.id.food_name1);
		//RatingBar foodBar = (RatingBar) view.findViewById(R.id.ratingBar);
		foodImage.setImageResource(food.getImageId());
		foodName.setText(food.getName());
		//foodBar.setRating(food.getBar().getRating());
		
		return view;
	}

}
