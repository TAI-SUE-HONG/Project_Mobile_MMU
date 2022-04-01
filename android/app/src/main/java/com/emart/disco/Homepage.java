package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity {
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        card1 = (CardView) findViewById(R.id.vege_act);
        card2 = (CardView) findViewById(R.id.meat_act);
        card3 = (CardView) findViewById(R.id.fruit_act);
        card4 = (CardView) findViewById(R.id.dairy_act);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Product_catalog.class));
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Product_catalog.class));
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Product_catalog.class));
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Product_catalog.class));
            }
        });

        //Initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_navigation);

        //Set Home Select
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_my_cart:
                        startActivity(new Intent(getApplicationContext(), disco_cart.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(getApplicationContext(), Login_activity.class));
                        overridePendingTransition(0,0);
                        finishAndRemoveTask();
                        return true;
                }
                return false;
            }
        });

    }



    }
