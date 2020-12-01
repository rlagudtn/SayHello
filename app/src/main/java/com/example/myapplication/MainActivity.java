package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private PeopleList peopleList;
    private Vector<String> nameList;
    private long backBtnTime;
    TextView tvPersonNum;
    ImageButton imgbtn_add, imgbtn_more;
    ListView lv_people;


    Button btn_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_layout);

        if (this.peopleList == null) {

            this.peopleList = new PeopleList();
//            try {
//                FileInputStream inputStream=openFileInput("file.txt");
//                byte[] txt=new byte[30];
//                inputStream.read(txt);
//                String str=new String(txt)  ;
//                Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
//                inputStream.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                byte[] name= new byte[32];
//
               FileInputStream inputStream=openFileInput("file.txt");
                while(inputStream.read(name)!=-1) {
//                    inFs.read(phoneNumber);
//                    inFs.read(group);
//                    inFs.read(birth);
                    this.peopleList.addPerson(new Person(new String(name), "phoneNumber"));//.toString(),
//                            group.toString(), birth.toString()));

                    inputStream.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        tvPersonNum = findViewById(R.id.tvPersonNum);
        imgbtn_add = findViewById(R.id.imgbtn_add);
        imgbtn_more = findViewById(R.id.imgbtn_more);

        Intent intent = getIntent();

        peopleList.addPerson(new Person("홍길동1", "010"));
        Person person = (Person) intent.getSerializableExtra("개인");
        //Toast.makeText(this, person.name.toString(),Toast.LENGTH_SHORT).show();
        //추가되는 개인을 저장한다.
        if (person != null) {
            this.peopleList.addPerson(person);

            try {
                //peopleList.addPerson(new Person("홍길동2", "010"));
                Toast.makeText(this,"끝",Toast.LENGTH_SHORT).show();
                FileOutputStream outFs=openFileOutput("file.txt", Context.MODE_PRIVATE);
                 for(int i=0;i<this.peopleList.getSize();i++){
                        Person temp =this.peopleList.getPerson(i);

                     byte[] by=temp.name.getBytes();
                    outFs.write(by);
                    outFs.close();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        for(int i=0;i<peopleList.getSize();i++){
//            Toast.makeText(this, this.peopleList.getPerson(i).name.toString(),Toast.LENGTH_SHORT).show();
//
//        }

        lv_people = (ListView) findViewById(R.id.lv_people);
        PeopleListAdapter peopleListAdapter = new PeopleListAdapter(this.peopleList, getApplicationContext());
        lv_people.setAdapter(peopleListAdapter);

        //button 클릭시
        imgbtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddPersonActivity.class);

                startActivity(intent);
            }
        });


    }

    //ctrl + o ==>리스트 출력
    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if (gapTime >= 0 && gapTime <= 2000) {
//                    try {
//            FileOutputStream outFs=openFileOutput("file.txt", Context.MODE_PRIVATE);
//
//            String str ="오늘 날씨는 굿";
//            byte[] by=str.getBytes();
//            outFs.write(by);
//            outFs.close();} catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



            super.onBackPressed();

        } else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}