package com.example.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivPhotoDetail;
    private TextView tvNameDetail, tvAboutDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhotoDetail = findViewById(R.id.iv_photoDetail);
        tvNameDetail = findViewById(R.id.tv_nameDetail);
        tvAboutDetail = findViewById(R.id.tv_aboutDetail);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("varName");
        String tentang = intent.getStringExtra("varAbout");
        String foto = intent.getStringExtra("varPhoto");

        setTitle(nama);
        tvNameDetail.setText(nama);
        tvAboutDetail.setText(tentang);
        Glide.with(this)
                .load(foto)
                .into(ivPhotoDetail);
    }
}