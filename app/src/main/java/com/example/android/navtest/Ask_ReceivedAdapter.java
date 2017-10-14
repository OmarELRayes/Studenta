package com.example.android.navtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Omar on 5/1/2017.
 */

public class Ask_ReceivedAdapter extends RecyclerView.Adapter<Ask_ReceivedAdapter.ViewHolder> {

    List<Ask_Received_ListItem> ask_Received_listItems;
    private Context context;

    public Ask_ReceivedAdapter(List<Ask_Received_ListItem> ask_Received_listItems, Context context) {
        this.ask_Received_listItems = ask_Received_listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ask_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ask_Received_ListItem receivedListItems = ask_Received_listItems.get(position);
        holder.name.setText(receivedListItems.getName());
        holder.title.setText(receivedListItems.getTitle());
        holder.mainIcon.setImageResource(receivedListItems.getMainIcon());
        holder.stateIcon.setImageResource(receivedListItems.getStateIcon());
    }

    @Override
    public int getItemCount() {
        return ask_Received_listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mainIcon;
        public ImageView stateIcon;
        public TextView name;
        public TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            mainIcon = (ImageView) itemView.findViewById(R.id.q_pic);
            stateIcon = (ImageView) itemView.findViewById(R.id.q_state);
            name = (TextView) itemView.findViewById(R.id.q_name);
            title = (TextView) itemView.findViewById(R.id.q_title);
        }
    }

}
