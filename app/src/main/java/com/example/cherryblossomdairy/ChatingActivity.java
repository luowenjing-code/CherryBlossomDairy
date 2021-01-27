package com.example.cherryblossomdairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ChatingActivity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<>();

    private EditText inputText;

    private Button send;

    private RecyclerView msgRecyclerView;

    private MsgAdapter adapter;

    private void initMsgs()
    {
        Msg msg1=new Msg("你好，请问需要什么帮助！",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("你好，我有一些问题想咨询",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3=new Msg("请你描述一下你的问题",Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chating);
        initMsgs();//初始化消息数据
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String content=inputText.getText().toString();
                if(!"".equals(content))
                {
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将ListView定位到最后一行
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
    }
}