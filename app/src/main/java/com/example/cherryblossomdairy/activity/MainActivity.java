package com.example.cherryblossomdairy.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cherryblossomdairy.Dairy;
import com.example.cherryblossomdairy.R;
import com.example.cherryblossomdairy.adapter.DairyAdapter;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Dairy>dairyList=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏顶部标题
        ActionBar act=getSupportActionBar();
        act.hide();
        Button button=(Button)findViewById(R.id.make_dairy);
        button.setOnClickListener(this);
        LitePal.getDatabase();//自动创建litepal数据库
        getData();
        refreshData();
        recyclerView=(RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DairyAdapter dairyAdapter=new DairyAdapter(dairyList);
        recyclerView.setAdapter(dairyAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DairyAddActivity.class);
        startActivity(intent);
    }

        private void getData() {//初始化数据
            Dairy test = new Dairy();
            test.setDairy_title("一个测试");
            test.setDairy_content("Hello Android!");
            dairyList.add(test);
        }
        private void refreshData() {//更新数据
            dairyList.clear();
            dairyList = LitePal.findAll(Dairy.class);
        }
    }
