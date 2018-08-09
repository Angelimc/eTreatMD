package com.example.angeli.patientprofiles;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private ListView lv;
    private List<String> patientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        lv = (ListView) findViewById(R.id.listView);
        /*fetch data from the web*/
        Fetcher fetcher = new Fetcher();
        fetcher.execute("https://api.myjson.com/bins/uj26j");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) lv.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,Profile.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }


    public void PatientAdapter(String json){
        patientList = JsonParser.parse(json);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, patientList);
        lv.setAdapter(adapter);
    }

    //AsyncTask
    private class Fetcher extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String data = HttpManager.getData(params[0]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            PatientAdapter(s);
            pb.setVisibility(View.INVISIBLE);
        }
    }
}