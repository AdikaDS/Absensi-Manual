package com.example.absensimanual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainLogin extends AppCompatActivity {

    TabLayoutMediator mediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 page = findViewById(R.id.page);



        SampleAdapter adapter = new SampleAdapter(getSupportFragmentManager(), getLifecycle());
        page.setAdapter(adapter);

        mediator = new TabLayoutMediator(tabLayout, page, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position) {
                    case 0:
                        tab.setText("Masuk");
                        break;
                    case 1:
                        tab.setText("Register");
                        break;
                }
            }
        });
        mediator.attach();

    }

}