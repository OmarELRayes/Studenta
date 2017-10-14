package com.example.android.navtest;

/**
 * Created by Luffy on 5/14/2017.
 */
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.bloder.magic.view.MagicButton;
public class CustomReminder extends Activity {
    EditText title;
    EditText desc;
    EditText date;
@Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
    final Activity activity = this;
    setContentView(R.layout.custom_reminder);
    super.onCreate(savedInstanceState);
    title =(EditText)findViewById(R.id.editText3);
     desc=(EditText)findViewById(R.id.editText4);
     date=(EditText)findViewById(R.id.editText2);
    MagicButton mg=(MagicButton)findViewById(R.id.magic_button_twitter) ;


    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay() .getMetrics(dm);
    int width = dm.widthPixels;
    int height = dm.heightPixels ;
    getWindow().setLayout((int)(width*.7),(int)(height*.6));
    mg.setMagicButtonClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {

            ToDoList_ListItem custom = new ToDoList_ListItem(R.drawable.settings_icon,title.getText().toString(),desc.getText().toString(),date.getText().toString(),loginActivity.userEmail);
            ToDoListFragment.TDLListItems.add(custom);
            ToDoListFragment.adapter.notifyDataSetChanged();
            FirebaseDatabase database =FirebaseDatabase.getInstance();
            DatabaseReference databaseReference=database.getReference();
            databaseReference.child("TodoItem").push().setValue(custom);
            Toast.makeText(CustomReminder.this, "Item added", Toast.LENGTH_LONG).show();
            activity.finish();
        }
    });
}

}
