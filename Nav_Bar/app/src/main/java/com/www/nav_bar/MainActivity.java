package com.www.nav_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer_layout;
    private Toolbar toolbar;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        drawer_layout = findViewById(R.id.drawer);

        //for the hamburger icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout,toolbar, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView= findViewById(R.id.nav_view);

        //this is done to have same fragment if the screen is rotated
        if(savedInstanceState==null) {
    //this is done to load the default page when the app is just opened
    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new home()).commit();
    //this is done to check the item in nav bar which loaded as default
    navigationView.setCheckedItem(R.id.home1);
}

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,new home()).commit();
                    break;
                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new about()).commit();
                        break;
                    case R.id.message1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new message()).commit();
                        break;
                    case R.id.call:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new call()).commit();
                        break;
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, "you have clicked contact us icon", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawer_layout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }


    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}