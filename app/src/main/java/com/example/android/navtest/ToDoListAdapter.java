package com.example.android.navtest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Omar on 5/1/2017.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {
    List<ToDoList_ListItem> TDLListItems;
    private Context context;

    public ToDoListAdapter(List<ToDoList_ListItem> TDLListItems, Context context) {
        this.TDLListItems = TDLListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todolist_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoList_ListItem TDLListItem = TDLListItems.get(position);
        holder.textViewHead.setText(TDLListItem.getHead());
        holder.textViewDesc.setText(TDLListItem.getDesc());
        holder.textViewDate.setText(TDLListItem.getDate());
        holder.icon.setImageResource(TDLListItem.getIcon());


    }

    @Override
    public int getItemCount() {
        return TDLListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView icon;
        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewDate;
        public ViewHolder(View itemView) {
            super(itemView);
            icon = (CircleImageView) itemView.findViewById(R.id.tdl_icon);
            textViewHead = (TextView) itemView.findViewById(R.id.tdl_head);
            textViewDesc = (TextView) itemView.findViewById(R.id.tdl_desc);
            textViewDate = (TextView) itemView.findViewById(R.id.tdl_date);

        }
    }
}
