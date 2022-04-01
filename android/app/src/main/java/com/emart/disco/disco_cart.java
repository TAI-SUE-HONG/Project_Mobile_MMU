package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import Data.PaymentDao;
import Data.UserDataBase;
import model.Cart;
import model.Payment;

public class disco_cart extends AppCompatActivity {

    Button btn_location, btn_order;
    UserDataBase dataBase;
    RecyclerView recycle_cart_view;
    PaymentDao paymentDao;
    SharedPreferences sharedPreferences;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco_cart);

        recycle_cart_view = findViewById(R.id.recycler_cart);
        recycle_cart_view.setLayoutManager(new LinearLayoutManager(this));
        disco_cart_adapter adapter = new disco_cart_adapter(this);
        recycle_cart_view.setAdapter(adapter);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        List<Cart> Cart = dataBase.getCartDao().loadAllProduct();
        adapter.setProductName(Cart);
        adapter.notifyDataSetChanged();

        btn_location = findViewById(R.id.btn_location);
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(disco_cart.this,MapsActivity.class));
            }
        });

        btn_order = findViewById(R.id.orderbtn);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dataBase.getCartDao().getName();
                double gross = dataBase.getCartDao().getGrossPayment();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.HH:mm:ss");
                String currentDate = format.format(calendar.getTime());
                //shared preferences (Name, Mode)
                sharedPreferences = getSharedPreferences("location", MODE_PRIVATE);
                //get data from shared preference
                String location = sharedPreferences.getString("location", "");

                paymentDao = dataBase.getPaymentDao();
                Log.d("TAG", currentDate + "\n" + name + "\n" + gross + "\n" + location);
                Payment payment = new Payment(currentDate, name, location, gross);
                paymentDao.insert(payment);
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