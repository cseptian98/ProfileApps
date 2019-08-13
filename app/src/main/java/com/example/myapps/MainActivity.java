package com.example.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fragment.FragmentAbout;
import fragment.FragmentKontak;
import fragment.FragmentProfil;
import fragment.FragmentTambahTeman;
import fragment.FragmentTeman;
import model.Teman;

//3-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class MainActivity extends AppCompatActivity {

    private List<Teman> list = new ArrayList<>();
    private int backButtonCount;

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.view, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navProfil:
                    changeFragment(FragmentProfil.newInstance());
                    return true;
                case R.id.navKontak:
                    changeFragment(FragmentKontak.newInstance());
                    return true;
                case R.id.navTeman:
                    changeFragment(FragmentTeman.newInstance());
                    return true;
                case R.id.navTentang:
                    changeFragment(FragmentAbout.newInstance());
                    return true;
                case R.id.navTambah:
                    changeFragment(FragmentTambahTeman.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(FragmentProfil.newInstance());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }

    public void SignOut(View view) {
        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new
                        Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });
    }
}
