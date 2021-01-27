package com.example.cherryblossomdairy;

public class Msg {
    public static final int TYPE_RECEIVED=0;//消息类型，这是一条收到的消息
    public static final int TYPE_SENT=1;//消息类型，这是一条发出的消息
    private String content;//消息内容
    private int type;//消息类型

    public Msg(String content,int type)
    {
        this.content=content;
        this.type=type;
    }

    public String getContent()
    {
        return content;
    }

    public int getType()
    {
        return type;
    }
}
