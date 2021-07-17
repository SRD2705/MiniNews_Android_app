package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDeatilActivity extends AppCompatActivity {

    String head,body,short_body,img_link,link;
    private TextView titleTV,subDescTV,contentTV;
    private ImageView newsIV;
    private Button readNewsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_deatil);
        head = getIntent().getStringExtra("head");
        body = getIntent().getStringExtra("body");
        short_body = getIntent().getStringExtra("short_body");
        img_link = getIntent().getStringExtra("img_link");
        link = getIntent().getStringExtra("link");
        titleTV = findViewById(R.id.idTVTitle);
        subDescTV = findViewById(R.id.idTVSubDesc);
        contentTV = findViewById(R.id.idTVContent);
        newsIV = findViewById(R.id.idIVNews);
        readNewsBtn = findViewById(R.id.idBtnReadNews);
        titleTV.setText(head);
        subDescTV.setText(short_body);
//        contentTV.setText(body);
        Picasso.get().load(img_link).into(newsIV);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                startActivity(i);
            }
        });
    }
}