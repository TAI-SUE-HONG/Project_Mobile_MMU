package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Order_history extends AppCompatActivity {

    ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        RecyclerView order_recycleview;
        order_recycleview = findViewById(R.id.order_recycleview);

        ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();
        cartTestArrayList.add(new Cart_test(1, 05032022, 13.50));
        cartTestArrayList.add(new Cart_test(2, 06032022, 15.50));
        cartTestArrayList.add(new Cart_test(3, 07032022, 16.50));
        cartTestArrayList.add(new Cart_test(4, 01032022, 17.50));

        Order_history_Adapter adapter = new Order_history_Adapter(this, cartTestArrayList);
        order_recycleview.setAdapter(adapter);
        order_recycleview.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

        //Initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_navigation);

        //Set Home Select
        bottomNavigationView.setSelectedItemId(R.id.nav_order);

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