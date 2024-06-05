package com.example.uoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Splashscreen extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 8000; // Splash screen timer (3 seconds)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ImageView splashImage = findViewById(R.id.splash_image);

        // Load the GIF using Glide
        Glide.with(this)
                .asGif()
                .load(R.drawable.uo_splash)
                .into(splashImage);

        // Using a handler to delay the opening of the MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splashscreen.this, MainActivity.class);
                Splashscreen.this.startActivity(mainIntent);
                Splashscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
