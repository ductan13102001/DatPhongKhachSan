package com.example.datphongkhachsan;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.Toast;

    import com.google.android.material.tabs.TabItem;
    import com.google.android.material.tabs.TabLayout;

    public class ThietLapKhac_Activity extends AppCompatActivity {
        private TabLayout tab;
        private ImageView imgBack;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_thiet_lap_khac);

            tab = findViewById(R.id.tab);
            imgBack = findViewById(R.id.img_back);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Tab1Fragment()).commit();

            tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Tab1Fragment()).commit();
                            break;
                        case 1:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Tab2Fragment()).commit();
                            break;
                    }
                }
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }
    }