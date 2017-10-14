package com.example.android.navtest;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.app.AppCompatActivity;;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.EventListener;
import java.util.List;
import android.util.Log;

import android.app.FragmentTransaction;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoListFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    public static List<ToDoList_ListItem> TDLListItems;

    public ToDoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        final View reminderView = inflater.inflate(R.layout.custom_reminder, container, false);
        View rootview = inflater.inflate(R.layout.fragment_tdl, container, false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TDLListItems = new ArrayList<>();

        ToDoList_ListItem done = new ToDoList_ListItem(
                R.drawable.ic_assignment_turned_in_black_48dp,
                "Study For Quiz",
                "DataBase",
                "25/8",loginActivity.userEmail
        );
        TDLListItems.add(done);
        ToDoList_ListItem done1 = new ToDoList_ListItem(
                R.drawable.ic_assignment_turned_in_black_48dp,
                "Study For Quiz",
                "DataBase",
                "25/8",loginActivity.userEmail
        );
        TDLListItems.add(done1);
        for (int i=1; i<=10; i++){
            ToDoList_ListItem TDLListItem = new ToDoList_ListItem(
                    R.drawable.ic_assignment_late_black_48dp,
                    "Task "+i+" : Requirements",
                    "Software Engineering",
                    "29/5",loginActivity.userEmail
            );
            TDLListItems.add(TDLListItem);
        }
        adapter = new ToDoListAdapter(TDLListItems,getActivity());
        recyclerView.setAdapter(adapter);
        //get added items
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getInstance().getReference().child("TodoItem");
        final List<ToDoList_ListItem> customItems=new ArrayList<>();
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("Count " ,""+dataSnapshot.getChildrenCount());

                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                    {
                        ToDoList_ListItem item = postSnapshot.getValue(ToDoList_ListItem.class); //5las tl3 mn el for kk , i would do it xD
                            item.setIcon(R.drawable.settings_icon);

                        if(item.getEmail().equals(loginActivity.userEmail))
                         if(!customItems.contains(item))customItems.add(item);
                    }
                boolean exist=false;
                    for(ToDoList_ListItem tditem : customItems)
                    {
                        for(ToDoList_ListItem x:TDLListItems)
                            if (tditem==x) exist=true;
                        if(!exist) {TDLListItems.add(tditem);
                            ToDoListFragment.adapter.notifyDataSetChanged();}
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getMessage());
                }
            });







        FloatingActionButton floatingActionButton = ((HomeActivity) getActivity()).getFloatingActionButton();
        floatingActionButton.setImageResource(R.drawable.add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), CustomReminder.class);
                getActivity().startActivity(i);
                (getActivity()).overridePendingTransition(0,0);


//                Snackbar.make(view, "Add a custom item , other items are dynamic", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }

        });

        try {
            if (floatingActionButton != null) {
                floatingActionButton.show();
            }
        }
        catch (Exception e){

        }
        return rootview;
        // Inflate the layout for this fragment

    }


}
