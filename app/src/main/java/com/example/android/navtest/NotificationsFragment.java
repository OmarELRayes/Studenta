package com.example.android.navtest;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Notifications_ListItem> NotificationsListItems;
    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NotificationsListItems = new ArrayList<>();

        FloatingActionButton floatingActionButton = ((HomeActivity) getActivity()).getFloatingActionButton();
        try {
            if (floatingActionButton != null) {
                floatingActionButton.hide();
            }
        }
        catch (Exception e){

        }


        Notifications_ListItem quizRed = new Notifications_ListItem(
                R.drawable.ic_warning_red_48dp,
                "Quiz 1 : Chapter 1 , 2",
                "DataBase"
        );
        NotificationsListItems.add(quizRed);
        Notifications_ListItem quizRed1 = new Notifications_ListItem(
                R.drawable.ic_warning_red_48dp,
                "MidTerm Exam",
                "Management"
        );
        NotificationsListItems.add(quizRed1);
        Notifications_ListItem changeYellow = new Notifications_ListItem(
                R.drawable.ic_warning_yellow_48dp,
                "Lecture is Cancelled This Week",
                "Data Communication"
        );
        NotificationsListItems.add(changeYellow);
        for (int i=1; i<=10; i++){
            Notifications_ListItem TDLListItem = new Notifications_ListItem(
                    R.drawable.ic_warning_black_48dp,
                    "Task "+i+" : Requirements",
                    "Software Engineering"
                    );
            NotificationsListItems.add(TDLListItem);
        }
        adapter = new NotificationsAdapter(NotificationsListItems,getActivity());
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootview;
    }

}
