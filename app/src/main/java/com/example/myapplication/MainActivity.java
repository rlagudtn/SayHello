package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private PeopleList peopleList;
    private Vector<String> nameList;
    private long backBtnTime;
    TextView tvPersonNum;
    ImageButton imgbtn_add,imgbtn_more;
    ListView lv_people;

    String[] LIST={"홍길동","고길동","박길동"};

    Button btn_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_layout);

        if(this.peopleList==null){
            this.peopleList=new PeopleList();
            this.nameList=new Vector<String>();
        }
        tvPersonNum=findViewById(R.id.tvPersonNum);
        imgbtn_add=findViewById(R.id.imgbtn_add);
        imgbtn_more=findViewById(R.id.imgbtn_more);

        Intent intent=getIntent();
        Person person=new Person("홍길동","010");
        peopleList.addPerson(person);
        //Person person=(Person)intent.getSerializableExtra("개인");
        //Toast.makeText(this, person.name.toString(),Toast.LENGTH_SHORT).show();
        //추가되는 개인을 저장한다.
//        if(person!=null) {
//            this.peopleList.addPerson(person);
//        }
//        for(int i=0;i<peopleList.getSize();i++){
//            Toast.makeText(this, this.peopleList.getPerson(i).name.toString(),Toast.LENGTH_SHORT).show();
//
//        }

        lv_people=(ListView)findViewById(R.id.lv_people);
        ArrayAdapter adapter=new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,LIST);
        //lv_people.setAdapter(adapter);
        PeopleListAdapter peopleListAdapter=new PeopleListAdapter(this.peopleList,getApplicationContext());
//        String temp=peopleListAdapter.peopleList.getPerson(0).name;
        //Toast.makeText(this,temp,Toast.LENGTH_SHORT).show();
        lv_people.setAdapter(peopleListAdapter);




    }

    //ctrl + o ==>리스트 출력
    @Override
    public void onBackPressed() {
        long curTime= System.currentTimeMillis();
        long gapTime=curTime-backBtnTime;

        if(gapTime>=0 && gapTime<=2000){
            // 내장 메모리 저장
            super.onBackPressed();

        }
        else {
            backBtnTime=curTime ;
            Toast.makeText(this,"한번 더 누르면 종료됩니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}