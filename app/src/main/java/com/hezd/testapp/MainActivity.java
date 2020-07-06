package com.hezd.testapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hezd.lib.DownloadClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DownloadClient("111").start();
    }
}
