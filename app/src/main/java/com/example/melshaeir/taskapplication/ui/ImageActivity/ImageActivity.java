package com.example.melshaeir.taskapplication.ui.ImageActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.melshaeir.taskapplication.Model.Product;
import com.example.melshaeir.taskapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.http.GET;

public class ImageActivity extends AppCompatActivity {
    String imageId;
    ImageView imageMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageMain = (ImageView) findViewById(R.id.imagemain);
        imageId = getIntent().getStringExtra("image_ID");
        Picasso.with(getApplicationContext()).load(imageId).into(imageMain);
    }

}