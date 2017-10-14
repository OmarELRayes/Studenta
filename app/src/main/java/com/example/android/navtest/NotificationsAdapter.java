package com.example.android.navtest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Omar on 5/1/2017.
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    List<Notifications_ListItem> NotificationsListItems;
    private Context context;

    public NotificationsAdapter(List<Notifications_ListItem> NotificationsListItems, Context context) {
        this.NotificationsListItems = NotificationsListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notifications_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Notifications_ListItem TDLListItem = NotificationsListItems.get(position);
        holder.textViewHead.setText(TDLListItem.getHead());
        holder.textViewDesc.setText(TDLListItem.getDesc());
        holder.icon.setImageResource(TDLListItem.getIcon());
    }

    @Override
    public int getItemCount() {
        return NotificationsListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView textViewHead;
        public TextView textViewDesc;
        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.notif_icon);
            textViewHead = (TextView) itemView.findViewById(R.id.notif_head);
            textViewDesc = (TextView) itemView.findViewById(R.id.notif_desc);
        }
    }
}
