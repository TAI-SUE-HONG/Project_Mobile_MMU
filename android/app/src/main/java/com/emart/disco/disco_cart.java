package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class disco_cart extends AppCompatActivity {

    Button btn_order;
    ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco_cart);

        RecyclerView recycle_cart_view;
        recycle_cart_view = findViewById(R.id.recycler_cart);


        ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();
        cartTestArrayList.add(new Cart_test(1, 05032022, 13.50, 2));
        cartTestArrayList.add(new Cart_test(2, 06032022, 15.50,3));
        cartTestArrayList.add(new Cart_test(3, 07032022, 16.50,4));
        cartTestArrayList.add(new Cart_test(4, 01032022, 17.50,5));


        disco_cart_adapter adapter = new disco_cart_adapter(this, cartTestArrayList);
        recycle_cart_view.setAdapter(adapter);
        recycle_cart_view.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();


        btn_order = findViewById(R.id.orderbtn);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(disco_cart.this,Payment_details.class));
            }
        });




        //Initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_navigation);

        //Set Home Select
        bottomNavigationView.setSelectedItemId(R.id.nav_my_cart);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        return true;
                    case R.id.nav_my_cart:
                        startActivity(new Intent(getApplicationContext(), disco_cart.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_order:
                        startActivity(new Intent(getApplicationContext(), Order_history.class));
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