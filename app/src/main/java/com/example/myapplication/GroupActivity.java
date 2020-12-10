package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GroupActivity extends AppCompatActivity {
    ImageButton ibPrevious;
    Button btnRemove,btnAdd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_layout);

        ibPrevious=(ImageButton)findViewById(R.id.ibPrevious);
        btnRemove=findViewById(R.id.btnRemove);
        btnAdd =findViewById(R.id.btnAdd);

        //뒤로가기 눌렀을때
        ibPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(GroupActivity.this,MainActivity.class);

        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
