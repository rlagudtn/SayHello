package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddPersonActivity extends AppCompatActivity {

    String[] relation={"기타","가족","친구","지인"};
    String[] cycle={"1개월","3개월","6개월","1 년"};

    TextView tvGroup,tvCycle;
    EditText edtName,edtPhoneNum;
    Spinner spinGroup,spinCycle;
    DatePicker dpBirth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_person_layout);

        tvGroup=findViewById(R.id.tvGroup);
        tvCycle=findViewById(R.id.tvCycle);
        edtName=findViewById(R.id.edtName);
        edtPhoneNum=findViewById(R.id.edtPhoneNum);
        //커서 위치 글자 뒤로
        edtName.setSelection(edtName.length());
        edtPhoneNum.setSelection(edtPhoneNum.length());

        spinGroup=(Spinner)findViewById(R.id.spinGroup);
        spinCycle=(Spinner)findViewById(R.id.spinCycle);

        //그룹 adapter setting 및 클릭시 이벤트
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, relation);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinGroup.setAdapter(adapter);
        spinGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvGroup.setText(relation[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvGroup.setText(relation[0]);
            }
        });

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, cycle);
        adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinCycle.setAdapter(adapter1);
        spinCycle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvCycle.setText(cycle[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvCycle.setText(cycle[3]);
            }
        });

    }
}