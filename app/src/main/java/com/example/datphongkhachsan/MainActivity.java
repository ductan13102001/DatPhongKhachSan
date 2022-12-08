package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgWebcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgWebcome = (ImageView) findViewById(R.id.imgWebcome);
        imgWebcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hàm chuyển đổi màn hình
                Intent mhStart = new Intent(MainActivity.this, SignIn_Activity.class);
                startActivity(mhStart);
                finish();
            }
        });
    }
}