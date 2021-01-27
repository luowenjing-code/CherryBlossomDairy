package com.example.cherryblossomdairy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cherryblossomdairy.Dairy;
import com.example.cherryblossomdairy.R;

import java.util.List;

public class DairyAdapter extends ArrayAdapter<Dairy>
{
    private int resourceId;

    public DairyAdapter(Context context, int textViewResourceId, List<Dairy> objects)
    {
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Dairy dairy=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView dairytext=(TextView) view.findViewById(R.id.dairy_text);
        dairytext.setText(dairy.getDairy());
        return view;
    }
}
