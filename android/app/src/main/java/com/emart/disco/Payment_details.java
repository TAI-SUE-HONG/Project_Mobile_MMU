package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    TextView v_Date, v_Name, v_Location, v_Gross_payment, v_Delivery, v_Final_payment;
    Button Pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        payment_recycleview = findViewById(R.id.payment_recycleview);
        payment_recycleview.setLayoutManager(new LinearLayoutManager(this));
        Payment_details_Adapter adapter = new Payment_details_Adapter(this);
        payment_recycleview.setAdapter(adapter);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        List<Cart> Cart = dataBase.getCartDao().loadAllProduct();
        adapter.setPaymentDetail(Cart);
        adapter.notifyDataSetChanged();

//        for (int i=0; i< Cart.size(); i++) {
//            Log.d("TAG", Integer.toString(Cart.get(i).getQuantity()) + "\n" + Cart.get(i).getName() + "\n" + Cart.get(i).getPrice());
//        }

        v_Date = findViewById(R.id.value_date);
        v_Name = findViewById(R.id.value_name);
        v_Location = findViewById(R.id.value_location);
        v_Gross_payment = findViewById(R.id.value_gross_payment);
        v_Delivery = findViewById(R.id.value_delivery);
        v_Final_payment = findViewById(R.id.value_final_payment);

        List<Payment> Payment = dataBase.getPaymentDao().loadAllDetails();
        v_Date.setText(Payment.get(Payment.size()-1).getDate());
        v_Name.setText(Payment.get(Payment.size()-1).getName());
        v_Location.setText(Payment.get(Payment.size()-1).getLocation());
        v_Gross_payment.setText("RM " + String.format("%.2f", Payment.get(Payment.size()-1).getGross_payment()));
        v_Delivery.setText("RM 3.00");
        v_Final_payment.setText("RM" + String.format("%.2f", Payment.get(Payment.size()-1).getFinal_price()));

        Pay = findViewById(R.id.btn_payment);
        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = v_Date.getText().toString();
                dataBase.getCartDao().delete();
                Toast.makeText(getApplicationContext(), "Thank you for your purchase!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Payment_details.this, Homepage.class));
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