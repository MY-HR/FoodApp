package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *  显示菜单列
 */

public class MenuActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("aaa", "onCreate: ");
        setContentView(R.layout.menu_activity_fragment);
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }
}
