package com.example.angeli.patientprofiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

        private TextView textName;
        private TextView textId;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            textName = (TextView)findViewById(R.id.textView1);
            textId = (TextView)findViewById(R.id.textView2);

            Patient patient = (Patient) getIntent().getSerializableExtra("data");
            String name = "name: " + patient.getName();
            String id = "id: " + patient.getId();
            textName.setText(name);
            textId.setText(id);
    }
}