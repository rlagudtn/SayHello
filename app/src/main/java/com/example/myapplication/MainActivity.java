package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView lv_people;
    String [] items={"ㅅ","아너미ㅏㅓ라"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_layout);

        lv_people=(ListView)findViewById(R.id.lv_people);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
        lv_people.setAdapter(adapter);

    }
}