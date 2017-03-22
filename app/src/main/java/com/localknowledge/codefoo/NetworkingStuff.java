package com.localknowledge.codefoo;

import android.os.AsyncTask;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class NetworkingStuff extends AsyncTask<URL, String, String> {
    ArrayList<JsonObject>  jsonObjects= new ArrayList<>();
    JsonObject test;

    @Override
    protected void onPostExecute(String s) {
    }

    @Override
    protected void onPreExecute() {
//
    }

    @Override
    protected String doInBackground(URL... urls) {
        URL url = null;
        HttpURLConnection connection = null;

        try {
            for (int i=0; i<=130; i+=20) {
                url = new URL("http://ign-apis.herokuapp.com/articles?startIndex=" + i + "&count=20");
                connection = (HttpURLConnection) url.openConnection();
                JsonParser jp = new JsonParser();
                test = (JsonObject) jp.parse((new InputStreamReader(connection.getInputStream())));
                jsonObjects.add(test);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }
}
