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

public class Payment_details extends AppCompatActivity {

    ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        RecyclerView payment_recycleview;
        payment_recycleview = findViewById(R.id.payment_recycleview);

        ArrayList<Cart_test> cartTestArrayList = new ArrayList<>();


        Payment_details_Adapter adapter = new Payment_details_Adapter(this, cartTestArrayList);
        payment_recycleview.setAdapter(adapter);
        payment_recycleview.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }
}