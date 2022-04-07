package com.emart.disco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Data.CartDao;
import Data.UserDataBase;
import model.Cart;

@SuppressWarnings("UnnecessaryCodeBlock")
public class Product_catalog extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    CartDao cartDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_catalog);

        btn1=findViewById(R.id.add_button_tomato);
        btn2=findViewById(R.id.add_button_spinach);
        btn3=findViewById(R.id.add_button_bellpepper);
        btn4=findViewById(R.id.add_button_ladyfinger);


        cartDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries().build().getCartDao();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="Tomato";
                int quantity = 1;
                double price = 6.00;

                if(!cartDao.getCart(name)) {
                    Cart cart = new Cart(name, quantity, price);
                    cartDao.insert(cart);
                    Toast.makeText(Product_catalog.this, "Product Tomato has been successfully added!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Product_catalog.this, "To add more go to Cart!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="Chicken Wing";
                int quantity = 1;
                double price = 10.00;

                if(!cartDao.getCart(name)) {
                    Cart cart = new Cart(name, quantity, price);
                    cartDao.insert(cart);
                    Toast.makeText(Product_catalog.this, "Product chicken Wing has been successfully added!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Product_catalog.this, "To add more go to Cart!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="Bell pepper";
                int quantity = 1;
                double price = 6.00;

                if(!cartDao.getCart(name)) {
                    Cart cart = new Cart(name, quantity, price);
                    cartDao.insert(cart);
                    Toast.makeText(Product_catalog.this, "Product bell pepper has been successfully added!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Product_catalog.this, "To add more go to Cart!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="Lady Finger";
                int quantity = 1;
                double price = 5.00;

                if(!cartDao.getCart(name)) {
                    Cart cart = new Cart(name, quantity, price);
                    cartDao.insert(cart);
                    Toast.makeText(Product_catalog.this, "Product lady finger has been successfully added!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Product_catalog.this, "To add more go to Cart!", Toast.LENGTH_SHORT).show();
                }
            }
        });

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