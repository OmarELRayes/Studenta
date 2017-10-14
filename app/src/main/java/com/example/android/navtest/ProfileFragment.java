package com.example.android.navtest;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FloatingActionButton floatingActionButton = ((HomeActivity) getActivity()).getFloatingActionButton();
        floatingActionButton.setImageResource(R.drawable.question_sign);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ask That Guy a Question , To be added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // k
        try {
            if (floatingActionButton != null) {
                floatingActionButton.show();

            }
        }
        catch (Exception e){

        }
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

}
