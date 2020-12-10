package com.example.myapplication;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class PeopleListAdapter extends BaseAdapter {


    public PeopleList peopleList;
    Context context;

    public PeopleListAdapter(PeopleList people,Context context){

        this.peopleList=people;
        this.context=context;
    }
    @Override
    public int getCount() {
        return this.peopleList.getSize();
    }

    @Override
    public Object getItem(int position) {
        return this.peopleList.getPerson(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.items_list, parent, false);

        ImageView imageView=(ImageView)convertView.findViewById(R.id.iv_user);
        TextView name=(TextView)convertView.findViewById(R.id.tv_name);

        Person person=peopleList.getPerson(position);

        //각 element 에 데이터 반영
        name.setText(person.name);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,(position+1)+"번째 선택",
                        Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
