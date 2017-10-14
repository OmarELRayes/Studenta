package com.example.android.navtest;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiscussionsFragment extends Fragment {


    public DiscussionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FloatingActionButton floatingActionButton = ((HomeActivity) getActivity()).getFloatingActionButton();
        try {
            if (floatingActionButton != null) {
                floatingActionButton.hide();
            }
        }
        catch (Exception e){

        }
        // hwa galk 2mta 2sln ? lma 3mlt run
        // feelsbadman T_T
        // :( ...    5las h7awl ana ty <3 <3 xoxo

        return inflater.inflate(R.layout.fragment_discussions, container, false);
    }

}
