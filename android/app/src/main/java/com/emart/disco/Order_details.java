package com.emart.disco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Order_details extends AppCompatActivity {

    ArrayList<Order> OrderArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        RecyclerView order_recycleview;
        order_recycleview = findViewById(R.id.order_details_recycleview0);

        ArrayList<Order> OrderArrayList = new ArrayList<>();
        OrderArrayList.add(new Order(getString(R.string.your_order_number), "A100"));
        OrderArrayList.add(new Order(getString(R.string.delivery_address), "idfghioearhniearghioeaprgeargpaerj iroghaeisrkgaei 51464163"));
        OrderArrayList.add(new Order(getString(R.string.total), "RM108.35"));
        OrderArrayList.add(new Order("testing", "idfghioearhniearghioeaprgeargpaerj iroghaeisrkgaei 51464163"));

        Order_details_Adapter adapter = new Order_details_Adapter(this, OrderArrayList);
        order_recycleview.setAdapter(adapter);
        order_recycleview.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

        RecyclerView order_recycleview1;
        order_recycleview1 = findViewById(R.id.order_details_recycleview1);

        Order_details_Adapter adapter1 = new Order_details_Adapter(this, OrderArrayList);
        order_recycleview1.setAdapter(adapter1);
        order_recycleview1.setLayoutManager(new LinearLayoutManager(this));
        adapter1.notifyDataSetChanged();

        RecyclerView order_recycleview2;
        order_recycleview2 = findViewById(R.id.order_details_recycleview2);

        Order_details_Adapter adapter2 = new Order_details_Adapter(this, OrderArrayList);
        order_recycleview2.setAdapter(adapter2);
        order_recycleview2.setLayoutManager(new LinearLayoutManager(this));
        adapter2.notifyDataSetChanged();
    }
}