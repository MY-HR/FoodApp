package com.example.foodapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 菜单栏碎片
 */

public class MenuFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Activity activity;

    private LinearLayout MenuItem1;
    private LinearLayout MenuItem2;
    private LinearLayout MenuItem3;
    private LinearLayout MenuItem4;
    private LinearLayout MenuItem5;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menu, container, false);

        initView();
        initEvent();

        return view;
    }

    private void initView(){
        MenuItem1 = (LinearLayout) view.findViewById(R.id.menu_item_1);
        MenuItem2 = (LinearLayout) view.findViewById(R.id.menu_item_2);
        MenuItem3 = (LinearLayout) view.findViewById(R.id.menu_item_3);
        MenuItem4 = (LinearLayout) view.findViewById(R.id.menu_item_4);
        MenuItem5 = (LinearLayout) view.findViewById(R.id.menu_item_5);
    }

    private void initEvent(){
        MenuItem1.setOnClickListener(this);
        MenuItem2.setOnClickListener(this);
        MenuItem3.setOnClickListener(this);
        MenuItem4.setOnClickListener(this);
        MenuItem5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_item_1:
                MenuActivity.actionStart(activity);
                break;
        }
    }
}
