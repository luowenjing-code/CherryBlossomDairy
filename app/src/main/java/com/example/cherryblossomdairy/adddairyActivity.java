package com.example.cherryblossomdairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adddairyActivity extends AppCompatActivity {
    private List<Dairy> dairyList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddairy);
        Button button2=(Button)findViewById(R.id.button2);
        final EditText editText=(EditText)findViewById(R.id.edit_text);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button2:
                        String input=editText.getText().toString();
                        Toast.makeText(adddairyActivity.this,"保存成功！",Toast.LENGTH_SHORT).show();
                        Dairy adairy=new Dairy(input);
                        dairyList.add(adairy);
                        DairyAdapter adapter=new DairyAdapter(adddairyActivity.this,R.layout.dairy_item, dairyList);
                        ListView listView=(ListView)findViewById(R.id.list_view);
                        listView.setAdapter(adapter);
                }
            }
        });
    }
}