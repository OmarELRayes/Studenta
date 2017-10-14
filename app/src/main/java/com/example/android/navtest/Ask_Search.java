package com.example.android.navtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luffy on 5/19/2017.
 */

public class Ask_Search extends AppCompatActivity {
    public static String sentName;
    public static String chosen;
    public static String emailSent;
    MaterialSearchView searchView;
    ListView lstview;
    List<String> emails=new ArrayList<>();
    List<String> lstSource=new ArrayList<>();
//    = {
//            "Mostafa Waleed",
//            "Momen Adel",
//            "Omar ELrayes",
//            "Abdallah Ahmed","Zyad Galal","Mohamed Hosam","Banan Emad",
//            "Esraa Ahmed",
//            "Aya Ahmed","Nahed Salah","Aya Ibrahim","Hend Adel",
//    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_search);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        lstview = (ListView)findViewById(R.id.lstView);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getInstance().getReference().child("users");
        final List<user> users=new ArrayList<>();

        ref.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Count " ,""+dataSnapshot.getChildrenCount()); //test
                users.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    user aUser = postSnapshot.getValue(user.class);
                    //if(item.getEmail().toString()==item.getEmail().toString())
                    users.add(aUser);
                }
                for(user auser : users){
                    if(!auser.getEmail().equals(loginActivity.userEmail))
                    {
                    lstSource.add(auser.fname);
                    emails.add(auser.getEmail().toString());
                    } else sentName=auser.getFname().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lstSource);
        lstview.setAdapter(adapter);

        //OnItemClick
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chosen = ((TextView)view).getText().toString();
                emailSent = emails.get(position);
                Intent i = new Intent(Ask_Search.this, Ask_PopUp.class);
                startActivity(i);
            }
        });


        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener()
        {
            @Override
            public void onSearchViewShown()
            {
            }

            @Override
            public void onSearchViewClosed() {
                lstview = (ListView)findViewById(R.id.lstView);
                ArrayAdapter adapter= new ArrayAdapter(Ask_Search.this,android.R.layout.simple_list_item_1,lstSource);
                lstview.setAdapter(adapter);

            }
        });
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    List<String> lstFound = new ArrayList<>();
                    for (String item : lstSource) {
                        if (item.contains(newText))
                            lstFound.add(item);
                    }
                    ArrayAdapter adapter = new ArrayAdapter(Ask_Search.this, android.R.layout.simple_list_item_1, lstFound);
                    lstview.setAdapter(adapter);
                } else {
                    ArrayAdapter adapter = new ArrayAdapter(Ask_Search.this, android.R.layout.simple_list_item_1, lstSource);
                    lstview.setAdapter(adapter);

                }
                return true;

            }
        });}
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;



    }
}
