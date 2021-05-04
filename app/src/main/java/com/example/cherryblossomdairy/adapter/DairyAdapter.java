package com.example.cherryblossomdairy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cherryblossomdairy.Dairy;
import com.example.cherryblossomdairy.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class DairyAdapter extends RecyclerView.Adapter<DairyAdapter.ViewHolder> {
    private List<Dairy>mDairyList=new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dairy_title_recycle,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dairy dairy=mDairyList.get(position);
        holder.dairytitle.setText(dairy.getDairy_title());
    }

    @Override
    public int getItemCount() {
        return mDairyList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView dairytitle;

        public  ViewHolder(View view){
            super(view);
            dairytitle=(TextView)view.findViewById(R.id.recycle_dairy_title);
        }
    }
    public DairyAdapter(List<Dairy>list){
        this.mDairyList= list;
    }
}
