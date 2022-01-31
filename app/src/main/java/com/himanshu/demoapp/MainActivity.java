package com.himanshu.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.himanshu.customergludemolibrary.CustomerGlu;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findvies();


    }

    private void findvies() {
        Toast.makeText(getApplicationContext(), "hg", Toast.LENGTH_SHORT).show();
    }
}