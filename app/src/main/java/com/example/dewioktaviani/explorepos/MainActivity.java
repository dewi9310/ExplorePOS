package com.example.dewioktaviani.explorepos;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.dewioktaviani.explorepos.Data.common.clsItem;
import com.example.dewioktaviani.explorepos.Data.repo.clsItemRepo;
import com.example.dewioktaviani.explorepos.Fragment.FragmentInventory;
import com.example.dewioktaviani.explorepos.Fragment.FragmentSales;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    PackageInfo pInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
        }
        clsItem item = new clsItem();
        item.setBitActive(1);
        item.setTxtCategory("2");
        item.setTxtItemCode("asdsd");
        try {
            new clsItemRepo(getApplicationContext()).create(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pInfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        Menu menu = navigationView.getMenu();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.inventory:
                        toolbar.setTitle("Inventory");
                        FragmentInventory inventoryFragment = new FragmentInventory();
                        FragmentTransaction fragmentTransactionInventory = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionInventory.replace(R.id.frame, inventoryFragment);
                        fragmentTransactionInventory.commit();
                        return true;
                    case R.id.sales:
                        toolbar.setTitle("Sales");
                        FragmentSales salesFragment = new FragmentSales();
                        FragmentTransaction fragmentTransactionsales = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionsales.replace(R.id.frame, salesFragment);
                        fragmentTransactionsales.commit();
                        return true;
                }
                return false;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}
