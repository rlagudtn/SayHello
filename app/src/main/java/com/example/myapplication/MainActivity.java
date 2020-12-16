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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager viewPager;
    private EventSlidePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setEventSlide();
    }

    private void setEventSlide(){
        ArrayList<String> text = new ArrayList<>();
        text.add("12월 31일");
        text.add("1월 11일");
        text.add("2월 21일");
        text.add("3월 31일");



        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new EventSlidePagerAdapter(getSupportFragmentManager());
        // ViewPager와  FragmentAdapter 연결
        viewPager.setAdapter(pagerAdapter);

        viewPager.setClipToPadding(false);
        int dpValue = 50;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(0, 0, margin, 0);
        viewPager.setPageMargin(margin/3);

        // FragmentAdapter에 Fragment 추가, text 개수만큼 추가
        for (int i = 0; i < text.size(); i++) {
            EventSlideFragment eventSlideFragment = new EventSlideFragment();
            Bundle bundle = new Bundle();
            bundle.putString("date", text.get(i));
            eventSlideFragment.setArguments(bundle);
            pagerAdapter.addItem(eventSlideFragment);
        }
        pagerAdapter.notifyDataSetChanged();
    }



}