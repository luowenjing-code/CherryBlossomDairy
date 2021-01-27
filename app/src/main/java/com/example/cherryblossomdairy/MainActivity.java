package com.example.cherryblossomdairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "已选择编辑日记", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent();
                intent1.setClass(MainActivity.this,adddairyActivity.class);
                startActivity(intent1);
                break;
            case R.id.chat_item:
                Toast.makeText(this, "已选择开启论坛", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent();
                intent2.setClass(MainActivity.this,ChatingActivity.class);
                startActivity(intent2);
                break;
            case R.id.search:
                Toast.makeText(this, "已选择浏览更多", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http：//www.baidu.com"));
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
        }
}
