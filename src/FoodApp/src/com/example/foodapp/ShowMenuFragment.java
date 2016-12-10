package com.example.foodapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 80561 on 2016/12/9.
 */

public class ShowMenuFragment extends Fragment{
    private View view;

    private List<Food> foods = new ArrayList<Food>();
    private FoodAdapterMain adapterMain;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu_activity, container, false);
        listView = (ListView) view.findViewById(R.id.menu_listView);
        initFoods();
        // 添加适配器 adapter
        adapterMain = new FoodAdapterMain(getActivity(), R.layout.food_item_main, foods);
        listView.setAdapter(adapterMain);

        return view;
    }

    //暂时用 手动方式添加菜色
    private void initFoods() {
        Food shengCai = new Food("生菜", R.drawable.ic_launcher);
        foods.add(shengCai);
        Food daBaiCai = new Food("大白菜", R.drawable.ic_launcher);
        foods.add(daBaiCai);
        Food aa = new Food("大白菜", R.drawable.ic_launcher);
        foods.add(aa);
        Food bb = new Food("大白菜", R.drawable.ic_launcher);
        foods.add(bb);
        Food cc = new Food("大白菜", R.drawable.ic_launcher);
        foods.add(cc);
        Food dd = new Food("大白菜", R.drawable.ic_launcher);
        foods.add(dd);
    }
}
