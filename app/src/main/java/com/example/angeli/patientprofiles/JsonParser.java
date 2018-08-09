package com.example.angeli.patientprofiles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<String> parseName(String json){

        try {
            JSONArray jsonArray = new JSONArray(json);
            List<String> patientNameList = new ArrayList<>();

            int i = 0;
            while (i < jsonArray.length()){
                JSONObject jb = jsonArray.getJSONObject(i);

                patientNameList.add(jb.getString("name"));
                i++;
            }

            return patientNameList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Patient> parseData(String json){

        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Patient> patientList = new ArrayList<>();

            int i = 0;
            while (i < jsonArray.length()){
                JSONObject jb = jsonArray.getJSONObject(i);
                Patient patient = new Patient(jb.getString("name"), jb.getString("id"));

                patientList.add(patient);
                i++;
            }

            return patientList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}