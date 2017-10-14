package com.example.android.navtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ask_ReceivedFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Ask_Received_ListItem> ask_received_listItems;
    public Ask_ReceivedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_ask__received, container, false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ask_received_listItems = new ArrayList<>();
//yep bos
        FloatingActionButton floatingActionButton = ((HomeActivity) getActivity()).getFloatingActionButton();
        try {
            if (floatingActionButton != null)
            {
                floatingActionButton.hide();
            }
        }
        catch (Exception e){
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getInstance().getReference().child("Ask");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Count " ,""+dataSnapshot.getChildrenCount());

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    Ask item = postSnapshot.getValue(Ask.class); //5las tl3 mn el for kk , i would do it xD
                    int icon;if(item.isAnswered())icon= R.drawable.ask_read; else icon=R.drawable.ask_unread;
                    if(item.getRecieverEmail().equals(loginActivity.userEmail))
                    {
                        Ask_Received_ListItem x=new Ask_Received_ListItem(R.drawable.profile,icon,item.getSentName(),item.getTitle());
                        if(!ask_received_listItems.contains(x))
                        {  ask_received_listItems.add(x);adapter.notifyDataSetChanged();}
                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        Ask_Received_ListItem unread1 = new Ask_Received_ListItem(
                R.drawable.profile,
                R.drawable.ask_unread,
                "Omar ELRayes",
                "About Task 3"
        );
        ask_received_listItems.add(unread1);
        Ask_Received_ListItem unread2 = new Ask_Received_ListItem(
                R.drawable.profile,
                R.drawable.ask_read,
                "Omar ELRayes",
                "About Task 3"
        );
        ask_received_listItems.add(unread2);
        Ask_Received_ListItem read1 = new Ask_Received_ListItem(
                R.drawable.profile,
                R.drawable.ask_read,
                "Omar ELRayes",
                "About Task 3"
        );
        ask_received_listItems.add(read1);
        Ask_Received_ListItem read2 = new Ask_Received_ListItem(
                R.drawable.profile,
                R.drawable.ask_read,
                "Omar ELRayes",
                "About Task 3"
        );
        ask_received_listItems.add(read2);
        for (int i=0; i <10; i++){
            Ask_Received_ListItem q = new Ask_Received_ListItem(
                    R.drawable.profile,
                    R.drawable.ask_read,
                    "Omar ELRayes",
                    "About Task 3"
            );
            ask_received_listItems.add(q);

        }

        adapter = new Ask_ReceivedAdapter(ask_received_listItems,getActivity());
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootview;
    }

}
