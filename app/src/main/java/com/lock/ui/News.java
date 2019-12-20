package com.lock.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;

public class News extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        String news = getIntent().getStringExtra("news");
        TextView text = findViewById(R.id.news);
        ImageView im = findViewById(R.id.close);
        text.setText("    "+news);
        im.setOnClickListener(v -> finish());
    }
}
