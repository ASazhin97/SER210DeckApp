/*
Alexandra Sazhin
Category Activity
AppCompat Activity
First Screen seen by User
Allows entry of parameters
 */

package com.ser210_02_asazhin.ser210deckapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoryActivity extends AppCompatActivity {
    EditText _deckName;
    EditText _colors;
    EditText _set;
    TextView _waitText;
    String set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        _deckName = (EditText) findViewById(R.id.deckNameEdit);
        _colors = (EditText) findViewById(R.id.colorEdit);
        _set = (EditText) findViewById(R.id.setEdit);
        _waitText = (TextView) findViewById(R.id.waitText);

        String[] setsArray = {"Legacy", "Commander", "Modern"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, setsArray);


    }

    public void onGenButtonClick(View view){
        //change text
        _waitText.setText("Please Wait, Generating");
        String deckName = _deckName.getText().toString();
        String colors = _colors.getText().toString();
        String set = _set.getText().toString();

        Intent intent = new Intent(this, DeckListActivity.class);
        intent.putExtra("name", deckName);
        intent.putExtra("colors", colors);
        intent.putExtra("set", set);
        startActivity(intent);
    }

}
