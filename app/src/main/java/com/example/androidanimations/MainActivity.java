package com.example.androidanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private ImageView profileimageView;
    private TextView profileText, profileDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        profileimageView = findViewById(R.id.imageView);
        profileText = findViewById(R.id.profilename);
        profileDesc = findViewById(R.id.desc);


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharedintent = new Intent(MainActivity.this, SharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(profileimageView, "imageTransition");
                pairs[1] = new Pair<View, String>(profileText, "nameTransition");
                pairs[2] = new Pair<View, String>(profileDesc, "descTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(sharedintent, options.toBundle());
            }
        });

    }
}
