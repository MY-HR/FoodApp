package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *  显示菜单列
 */

public class MenuActivity extends FragmentActivity implements View.OnClickListener {
    private int id;
    private List<Food> foods = new ArrayList<Food>();
    private FoodAdapter adapter;
    private ListView listView;

    private TextView topTitle, topBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu_activity);
        initView();
        id = getIntent().getIntExtra("Id", 1);
        switch (id){
            case 1:
                initFoods1();
                break;
            case 2:
                initFoods2();
                break;
        }
        // 添加适配器 adapter
        adapter = new FoodAdapter(this, R.layout.food_item, foods);
        listView.setAdapter(adapter);
        initEvent();
    }

    public static void actionStart(Context context, int Id){
        Intent intent = new Intent(context, MenuActivity.class);
        intent.putExtra("Id", Id);
        context.startActivity(intent);
    }

    private void initView(){
        listView = (ListView) findViewById(R.id.menu_listView);
        topTitle = (TextView) findViewById(R.id.top_layout_name);
        topBackBtn = (TextView) findViewById(R.id.top_back_btn);

        topTitle.setText("菜单");
        topBackBtn.setText("<");
    }
    private void initEvent(){
        topBackBtn.setOnClickListener(this);
    }

    //暂时用 手动方式添加菜色
    private void initFoods1() {
        Food shengCai = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(shengCai);
        Food daBaiCai = new Food("大白菜", R.drawable.ic_launcher, "￥10");
        foods.add(daBaiCai);
        Food aa = new Food("大白菜", R.drawable.ic_launcher, "￥10");
        foods.add(aa);
        Food bb = new Food("大白菜", R.drawable.ic_launcher, "￥10");
        foods.add(bb);
        Food cc = new Food("大白菜", R.drawable.ic_launcher, "￥10");
        foods.add(cc);
        Food dd = new Food("大白菜", R.drawable.ic_launcher, "￥10");
        foods.add(dd);
    }
    //暂时用 手动方式添加菜色
    private void initFoods2() {
        Food shengCai = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(shengCai);
        Food daBaiCai = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(daBaiCai);
        Food aa = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(aa);
        Food bb = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(bb);
        Food cc = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(cc);
        Food dd = new Food("生菜", R.drawable.ic_launcher, "￥10");
        foods.add(dd);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_back_btn:
                finish();
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                break;
        }
    }
}
