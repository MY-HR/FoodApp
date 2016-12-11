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
		View view;
		ViewHolder viewHolder;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.foodImage = (ImageView) view.findViewById(R.id.food_image1);
			viewHolder.foodName = (TextView) view.findViewById(R.id.food_name1);
			//RatingBar foodBar = (RatingBar) view.findViewById(R.id.ratingBar);
			view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.foodImage.setImageResource(food.getImageId());
		viewHolder.foodName.setText(food.getName());
		//foodBar.setRating(food.getBar().getRating());
		return view;
	}

	class ViewHolder{
		ImageView foodImage;
		TextView foodName;
	}

}
