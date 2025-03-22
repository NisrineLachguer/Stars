package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    private LottieAnimationView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);

        // Démarrer l'animation
        logo.playAnimation();

        // Redirection automatique vers ListActivity après la fin de l'animation
        logo.addAnimatorUpdateListener((animation) -> {
            if (animation.getAnimatedFraction() >= 1.0f) { // Vérifie si l'animation est terminée
                Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                startActivity(intent);
                finish(); // Détruit l'activité Splash après la redirection
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish(); // Assure que l'activité Splash est détruite si l'utilisateur la quitte
    }
}