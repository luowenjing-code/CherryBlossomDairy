package com.example.cherryblossomdairy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cherryblossomdairy.bean.Dairy;
import com.example.cherryblossomdairy.R;

import org.litepal.tablemanager.Connector;

public class DairyAddActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_add);
        final EditText editText1=(EditText) findViewById(R.id.add_dairy_title);
        final EditText editText2=(EditText) findViewById(R.id.add_dairy_content);
        Button adddairy=(Button)findViewById(R.id.keep_dairy_button);
        adddairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();//自动创建litepal数据库
                String title=editText1.getText().toString();
                String content=editText2.getText().toString();
                Dairy dairy=new Dairy();
                dairy.setDairy_title(title);
                dairy.setDairy_content(content);
                dairy.save();
                if(dairy.save()) {
                    Toast.makeText(DairyAddActivity.this, "保存成功！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DairyAddActivity.this, "保存失败！", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
