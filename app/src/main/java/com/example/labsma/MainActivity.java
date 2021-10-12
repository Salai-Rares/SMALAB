package com.example.labsma;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText eName ;
    Button bHello;
    Button bRandom;
    TextView tName ;
    Spinner spinner;
    Map<String,String> collorsMapped = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName=(EditText) findViewById(R.id.eName);
        bHello=(Button) findViewById(R.id.bHello);
        bRandom= (Button) findViewById(R.id.bRandom);
        tName= (TextView) findViewById(R.id.tName);
        spinner = (Spinner) findViewById(R.id.sCollors);
        collorsMapped.put("Black","#000000");
        collorsMapped.put("White","#FFFFFF");
        collorsMapped.put("Blue","#0000FF");
        collorsMapped.put("Yellow","#FFFF00");
        collorsMapped.put("Pink","#FFC0CB");
        collorsMapped.put("Brown","#964B00");
        collorsMapped.put("Red","#FF0000");
        collorsMapped.put("Green","#00FF00");
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.collors_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void clicked(View view) {
        switch (view.getId()){
            case R.id.bHello:
                new PopupGreeting().show(getSupportFragmentManager(),"Someting");
            case R.id.bRandom:
                tName.setText("Pressed RANDOM button");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String color = parent.getItemAtPosition(position).toString();
        bHello.setBackgroundColor(Color.parseColor(collorsMapped.get(color)));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}