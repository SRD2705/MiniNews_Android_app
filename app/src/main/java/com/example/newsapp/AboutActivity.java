package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView btn_linkedin;
    private TextView btn_github;
    private ImageView btn_fb;
    private ImageView btn_insta;
    private ImageView btn_twitter;
    private ImageView btn_gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btn_linkedin = findViewById(R.id.tvbtnLinkedin);
        btn_github = findViewById(R.id.tvbtnGithub);
        btn_fb = findViewById(R.id.tvAboutFb);
        btn_insta = findViewById(R.id.tvAboutInsta);
        btn_twitter = findViewById(R.id.tvAboutTwitter);
        btn_gmail = findViewById(R.id.tvAboutGmail);

        btn_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.linkedin.com/in/srd2705"));
                startActivity(i);
            }
        });

        btn_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/SRD2705"));
                startActivity(i);
            }
        });

        btn_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com/srd2705"));
                startActivity(i);
            }
        });

        btn_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.instagram.com/souravdasrishi"));
                startActivity(i);
            }
        });

        btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.facebook.com/souravdasrishi"));
                startActivity(i);
            }
        });

        btn_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("mailto:souravdasrishi@gmail.com"));
                startActivity(i);
            }
        });
    }
}