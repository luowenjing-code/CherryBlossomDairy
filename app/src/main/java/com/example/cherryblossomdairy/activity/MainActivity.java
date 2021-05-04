package com.example.cherryblossomdairy.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cherryblossomdairy.Dairy;
import com.example.cherryblossomdairy.R;
import com.example.cherryblossomdairy.adapter.DairyAdapter;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.callback.DatabaseListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*=================litepal数据库=====================*/
        LitePal.initialize(this);
        SQLiteDatabase db=LitePal.getDatabase(); //获取到SQLiteDatabase的实例，创建数据库表
        LitePal.registerDatabaseListener(new DatabaseListener() {
            /*监听数据库的创建和升级，一定要确保在任何其他数据库操作之前调
            然后当数据库创建的时候，onCreate()方法就会得到回调，当数据库升级的时候onUpgrade()方法就会得到回调
            并且告诉通过参数告诉你之前的老版本号，以及升级之后的新版本号。*/
            @Override
            public void onCreate() {//创建
                Toast.makeText(MainActivity.this,"数据库创建成功！",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onUpgrade(int oldVersion, int newVersion) {//升级
            }
        });
        /*======================================================*/
        Button button = (Button) findViewById(R.id.make_dairy);
        button.setOnClickListener(this);
        /*RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DairyAdapter dairyAdapter=new DairyAdapter();
        recyclerView.setAdapter(dairyAdapter);*/
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DairyAddActivity.class);
        startActivity(intent);
    }
}
