package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 80561 on 2016/12/11.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    private int resourceId;

    public FoodAdapter(Context context, int resource, List<Food> objects) {
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
            viewHolder.foodImage = (ImageView) view.findViewById(R.id.food_image2);
            viewHolder.foodName = (TextView) view.findViewById(R.id.food_name2);
            viewHolder.foodMoney = (TextView) view.findViewById(R.id.food_money);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.foodImage.setImageResource(food.getImageId());
        viewHolder.foodName.setText(food.getName());
        viewHolder.foodMoney.setText(food.getMoney());

        return view;
    }

    class ViewHolder{
        ImageView foodImage;
        TextView foodName;
        TextView foodMoney;
    }
}
