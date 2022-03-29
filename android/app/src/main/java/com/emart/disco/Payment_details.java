package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import Data.PaymentDao;
import Data.UserDataBase;
import model.Cart;
import model.Payment;

public class Payment_details extends AppCompatActivity {

    RecyclerView payment_recycleview;
    UserDataBase dataBase;
    PaymentDao paymentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        paymentDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries().build().getPaymentDao();


        payment_recycleview = findViewById(R.id.payment_recycleview);
        payment_recycleview.setLayoutManager(new LinearLayoutManager(this));
        Payment_details_Adapter adapter = new Payment_details_Adapter(this);
        payment_recycleview.setAdapter(adapter);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        List<Payment> Payment = dataBase.getPaymentDao().loadAllDetails();
        adapter.setPaymentDetail(Payment);
        adapter.notifyDataSetChanged();

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
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(0,0);
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