package com.example.angeli.patientprofiles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List parse(String json){

        try {
            JSONArray jsonArray = new JSONArray(json);
            List patientList = new ArrayList<>();

            int i = 0;
            while (i < jsonArray.length()){
                JSONObject jb = jsonArray.getJSONObject(i);

                patientList.add(jb.getString("name"));
                i++;
            }

            return patientList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}