package com.example.cherryblossomdairy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cherryblossomdairy.R;

public class DairyContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_content);
        String dairyTitle=getIntent().getStringExtra("dairy_title");//获取传入的日记标题
        String dairyContent=getIntent().getStringExtra("dairy_content");//获取传入的日记内容
        refresh(dairyTitle,dairyContent);//刷新DairyContentActivity界面
    }

    public static void actionStart(Context context, String dairy_title, String dairy_content){//自定义活动跳转的方法
        Intent intent=new Intent(context,DairyContentActivity.class);
        //通过Intent传递数据
        intent.putExtra("dairy_title",dairy_title);
        intent.putExtra("dairy_content",dairy_content);
        context.startActivity(intent);
    }

    public void refresh(String dairy_title,String dairy_content){
        TextView the_dairy_title=(TextView)findViewById(R.id.dairy_title);
        TextView the_dairy_content=(TextView)findViewById(R.id.dairy_content);
        the_dairy_title.setText(dairy_title);//刷新日记题目
        the_dairy_content.setText(dairy_content);//刷新日记内容
    }
}
