package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import Data.CartDao;
import Data.CartDatabase;
import model.Cart;

@SuppressWarnings("UnnecessaryCodeBlock")
public class Product_catalog extends AppCompatActivity {
    ArrayList<Cart> cartArrayList = new ArrayList<>();
    Button btn1,btn2,btn3,btn4;

    private CartDao cartDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);


        btn1=findViewById(R.id.add_button_tomato);



        //Initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bot_navigation);

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
        cartDao = Room.databaseBuilder(this, CartDatabase .class, "mi-database.db").allowMainThreadQueries().build().getCartDao();

        btn1.setOnClickListener(new View.OnClickListener() {
            private double price;
            private String name;

            @Override
            public void onClick(View view) {
//                public void setData (name, price) {
//                    this.name = name;
//                    this.price = price;
//                }
                String name="Tomato";
                double price = 6.00;
                Cart cart = new Cart(name,price);
                cartDao.insert(cart);
                Toast.makeText(Product_catalog.this, "Product successfully added!", Toast.LENGTH_SHORT).show();}
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            private double price;
            private String name;
            @Override
            public void onClick(View view) {
//                public void setData (name, price) {
//                    this.name = name;
//                    this.price = price;
//                }
                String name="Chicken Wing";
                double price = 10.00;
                Cart cart = new Cart(name,price);
                cartDao.insert(cart);
                Toast.makeText(Product_catalog.this, "Product successfully added!", Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            private double price;
            private String name;
            @Override
            public void onClick(View view) {
//                public void setData(name, price){
//                    this.name = name;
//                    this.price = price;
//                }
                String name="Bell pepper";
                double price = 6.00;
                Cart cart = new Cart(name,price);
                cartDao.insert(cart);
                Toast.makeText(Product_catalog.this, "Product successfully added!", Toast.LENGTH_SHORT).show();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            private double price;
            private String name;
            @Override
            public void onClick(View view) {
//                public void setData(name, price){
//                    this.name = name;
//                    this.price = price;
//                }
                String name="Lady Finger";
                double price = 5.00;
                Cart cart = new Cart(name,price);
                cartDao.insert(cart);
                Toast.makeText(Product_catalog.this, "Product successfully added!", Toast.LENGTH_SHORT).show();
            }
        });

    }



}