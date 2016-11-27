package com.example.foodapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFragment extends Fragment{

	private View view;
	private List<Food> foods = new ArrayList<Food>(); 
	private FoodAdapterMain adapterMain;
	private ListView listView;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);		
		initFoods();
		// ��������� adapter
		adapterMain = new FoodAdapterMain(activity, R.layout.food_item_main, foods);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		view = inflater.inflate(R.layout.home, container, false);				
        	
		listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(adapterMain);
		
		return view;
	}
	
	//��ʱ�� �ֶ���ʽ��Ӳ�ɫ
    private void initFoods() {
		Food shengCai = new Food("����", R.drawable.ic_launcher);
		foods.add(shengCai);
		Food daBaiCai = new Food("��ײ�", R.drawable.ic_launcher);
		foods.add(daBaiCai);
		Food aa = new Food("��ײ�", R.drawable.ic_launcher);
		foods.add(aa);
		Food bb = new Food("��ײ�", R.drawable.ic_launcher);
		foods.add(bb);
		Food cc = new Food("��ײ�", R.drawable.ic_launcher);
		foods.add(cc);
		Food dd = new Food("��ײ�", R.drawable.ic_launcher);
		foods.add(dd);
	}
}
