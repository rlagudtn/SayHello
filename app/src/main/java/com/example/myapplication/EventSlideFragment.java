package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EventSlideFragment extends Fragment {
    @Nullable


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.even_slide,container,false);

        //ImageView imageView = view.findViewById(R.id.iv_logo);
        TextView tv_date=view.findViewById(R.id.tv_date);
        TextView tv_aboutEvent=view.findViewById(R.id.tv_aboutEvent);
        if (getArguments() != null) {
            Bundle args = getArguments();
            // MainActivity에서 받아온 Person을 ImageView에 셋팅

            tv_date.setText(args.getString("date"));

            //String str=args.getString("name");
            //tv_aboutEvent.setText(str);
        }

        return view;}
}
