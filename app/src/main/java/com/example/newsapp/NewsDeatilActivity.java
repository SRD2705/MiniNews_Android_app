package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import retrofit2.http.Url;

public class NewsDeatilActivity extends AppCompatActivity {

    String head,body,short_body,img_link,link;
    private TextView titleTV,subDescTV,contentTV;
    private ImageView newsIV;
    private Button readNewsBtn;
    private Button shareBtn;
    private Button copyBtn;
    private ImageView fullimage;

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

        shareBtn = findViewById(R.id.idBtnShare);
        copyBtn = findViewById(R.id.idBtnCopy);

        final String copytext = head +"\n\n"+ short_body;
        final ScrollView parent = findViewById(R.id.svScrollable);

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

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text",copytext);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(NewsDeatilActivity.this, "The news is copied to clipboard", Toast.LENGTH_LONG).show();
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = Bitmap.createBitmap(parent.getWidth(),400,Bitmap.Config.ARGB_8888);
//                BitmapDrawable drawable = (BitmapDrawable)newsIV.getDrawable();
//                Bitmap bitmap = drawable.getBitmap();
                Canvas canvas = new Canvas(bitmap);
                parent.draw(canvas);

                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
                Uri uri = Uri.parse(bitmapPath);


                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/png/jpg/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM,uri);
                intent.putExtra(Intent.EXTRA_TEXT,copytext);
                intent.setType("text/plain");
                intent = Intent.createChooser(intent,"Share Via");
                startActivity(intent);
            }
        });

    }
}