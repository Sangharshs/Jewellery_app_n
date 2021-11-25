package com.example.jewelleryapp.AllActivities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.jewelleryapp.Fragments.CartFragment;
import com.example.jewelleryapp.Fragments.CategoryFragment;
import com.example.jewelleryapp.Fragments.HomeFragment;
import com.example.jewelleryapp.Fragments.ProfileFragment;
import com.example.jewelleryapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    View v;
    ImageView menuIcon;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         initView();

         clickListeners();

    }

    private void clickListeners() {
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        v = findViewById(R.id.toolBView);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menuIcon = v.findViewById(R.id.menuIcon);
    }

    HomeFragment homeFragment = new HomeFragment();
    CategoryFragment productFragment = new CategoryFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    CartFragment cartFragment = new CartFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                return true;

            case R.id.products:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, productFragment).commit();
                return true;

            case R.id.userProfile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                return true;

            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, cartFragment).commit();
                return true;
        }
        return false;
    }
}