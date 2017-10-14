package com.example.android.navtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Calendar;
import br.com.bloder.magic.view.MagicButton;

/**
 * Created by Luffy on 5/20/2017.
 */

public class Ask_PopUp extends Activity {

    EditText title;
    EditText question;
    TextView sentTo;

    protected void onCreate(@Nullable Bundle savedInstanceState){
       final Activity activity=this;
        setContentView(R.layout.ask_popup);
        super.onCreate(savedInstanceState);
        sentTo=(TextView)findViewById(R.id.email) ;
        sentTo.setText(Ask_Search.emailSent);
        title=(EditText)findViewById(R.id.title);
        question=(EditText)findViewById(R.id.question);
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
                Calendar c =Calendar.getInstance();
                Ask Q=new Ask(1,Ask_Search.sentName,Ask_Search.chosen,title.getText().toString(),question.getText().toString(),loginActivity.userEmail,sentTo.getText().toString(),c.getTime());
                FirebaseDatabase database =FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=database.getReference();
                databaseReference.child("Ask").push().setValue(Q);
                 Toast.makeText(Ask_PopUp.this, "Question sent", Toast.LENGTH_LONG).show();

                    activity.finish();
            }
        });
    }
}
