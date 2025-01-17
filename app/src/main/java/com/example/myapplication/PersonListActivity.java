package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class PersonListActivity extends AppCompatActivity {

    private PeopleList peopleList;
    private Vector<String> nameList;
    private long backBtnTime;
    TextView tvPersonNum;
    ImageButton imgbtn_add, imgbtn_more;
    ListView lv_people;
    Button btnGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.person_list_layout);

        if (this.peopleList == null) {

            this.peopleList = new PeopleList();
//
            try {
                int size;
                FileInputStream inputStream = openFileInput("file.txt");
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));


                String name="";
                while((name=bufferedReader.readLine())!=null){

                    this.peopleList.addPerson(new Person(new String(name), "phoneNumber"));//.toString(),
//                            group.toString(), birth.toString()));
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        tvPersonNum = findViewById(R.id.tvPersonNum);
        imgbtn_add = findViewById(R.id.imgbtn_add);
        imgbtn_more = findViewById(R.id.imgbtn_more);

        //Toast.makeText(this, person.name.toString(),Toast.LENGTH_SHORT).show();
        //추가되는 개인을 저장한다.
        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(outFs));
            for(int i=0;i<this.peopleList.getSize();i++){
                Person newPerson=this.peopleList.getPerson(i);
                bufferedWriter.write(newPerson.name);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//



        btnGroup=findViewById(R.id.btnGroup);
        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonListActivity.this, GroupActivity.class);

                startActivityForResult(intent,0);
                finish();
            }
        });
        lv_people = (ListView) findViewById(R.id.lv_people);
        PeopleListAdapter peopleListAdapter = new PeopleListAdapter(this.peopleList, getApplicationContext());
        lv_people.setAdapter(peopleListAdapter);

        //button 클릭시
        imgbtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonListActivity.this, AddPersonActivity.class);

                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Intent intent = getIntent();

            Person person = (Person) intent.getSerializableExtra("person");
            if (person != null) {
                this.peopleList.addPerson(person);
            }
        }

    }

    //ctrl + o ==>리스트 출력
    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if (gapTime >= 0 && gapTime <= 2000) {

            super.onBackPressed();

        } else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
