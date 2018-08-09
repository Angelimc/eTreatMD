package com.example.angeli.patientprofiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

        TextView tv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            tv = (TextView)findViewById(R.id.textView);

            //store the text in variable
            String name = getIntent().getExtras().getString("name");
            //display text
            tv.setText(name);
    }
}