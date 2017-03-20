package com.localknowledge.codefoo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity {

    NetworkingStuff temp = new NetworkingStuff();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
//        ab.setTitle("IGN Today");
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fffafafa")));
        ab.setElevation(20);

        temp.execute();
        try {
            temp.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        NewsCardAdapter adapter = new NewsCardAdapter(temp.jsonObjects);

        recyclerView.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(lm);
    }

    public void onClick(View v){
        CardView cv = (CardView) v;
        LinearLayout ll = (LinearLayout) cv.getChildAt(0);

        Intent intent = new Intent(this, WebviewActivity.class);
        intent.putExtra("address", ll.getChildAt(0).getContentDescription().toString());
        startActivity(intent);
    }
}
