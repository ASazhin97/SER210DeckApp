/*
Alexandra Sazhin
Deck List Activity
List Activity
Displays the Generated Deck
As a ListView
 */


package com.ser210_02_asazhin.ser210deckapp;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DeckListActivity extends ListActivity {

    ArrayList<String> deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deck = new ArrayList<String>();
        //deck.add("hi");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, deck);
        setListAdapter(adapter);


        //get stuff from Intent
        String set = getIntent().getStringExtra("set");
        String colors = getIntent().getStringExtra("colors");
        String name = getIntent().getStringExtra("name");

        GenAsync gen = new GenAsync();
        gen.execute(name, set, colors);

        //add from the generated deck into the deck for the List view
        try {
            ArrayList<String> deckSynk = gen.get();
            for(int i = 0; i<deckSynk.size(); i++){
                deck.add(deckSynk.get(i));
            }


        } catch(InterruptedException e){
            e.printStackTrace();
        } catch(ExecutionException e){
            e.printStackTrace();
        }

    }

}
