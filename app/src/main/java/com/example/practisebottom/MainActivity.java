package com.example.practisebottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.practisebottom.Fragments.HomeFragment;
import com.example.practisebottom.Fragments.PhoneFragment;
import com.example.practisebottom.Fragments.RadioFragment;
import com.example.practisebottom.Fragments.SearchFragment;
import com.example.practisebottom.Fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNavView = findViewById(R.id.bottom_navigation);

        btNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.home) loadFragment(new HomeFragment());
                else if(id==R.id.search) loadFragment(new SearchFragment());
                else if(id==R.id.settings) loadFragment(new SettingsFragment());
                else if(id==R.id.radio) loadFragment(new RadioFragment());
                else if(id==R.id.phone) loadFragment(new PhoneFragment());

                return true;
            }
        });
        btNavView.setSelectedItemId(R.id.phone);  // this sets the default item to be selected auto
                                                // always

    }

    void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();

    }
}