package com.emart.disco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.text.DecimalFormat;
import java.util.List;

import Data.CartDao;
import Data.UserDataBase;
import model.Cart;

public class disco_cart_adapter extends RecyclerView.Adapter<disco_cart_adapter.Viewholder> {
    Context context;
    UserDataBase dataBase;
    CartDao cartDao;
    List<Cart> CartList;

    public disco_cart_adapter(Context context) {
        this.context = context;
        notifyDataSetChanged();
    }

    public void setProductName(List<Cart> CartList) {
        this.CartList = CartList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false);
        return new disco_cart_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        //assigning values to view created in the recycleview layout file
        //all based on the position of the recycleview
        dataBase = Room.databaseBuilder(context, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        holder.Product.setText(CartList.get(position).getName());
        holder.Price.setText("RM " + String.format("%.2f", CartList.get(position).getPrice()));
        holder.Value.setText(Integer.toString(CartList.get(position).getQuantity()));
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBase.getCartDao().deleteCart(CartList.get(position).getName());
                CartList.remove(position);

                notifyDataSetChanged();
            }
        });
        holder.Add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int newValue = 1 + Integer.parseInt(holder.Value.getText().toString());
                holder.Value.setText(Integer.toString(newValue));
                dataBase.getCartDao().update(CartList.get(position).getName(),newValue);

            }
        });

        holder.Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newValue = Integer.parseInt(holder.Value.getText().toString())-1;
                holder.Value.setText(Integer.toString(newValue));
                dataBase.getCartDao().update(CartList.get(position).getName(),newValue);
            }
        });

    }

    @Override //the number of items in cart
    public int getItemCount() {
        return CartList == null ? 0 : CartList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        //grabbing layout from order_history_adapter

        Button Add, Minus, Delete;
        TextView Value, Product, Price;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Add = itemView.findViewById(R.id.add);
            Minus = itemView.findViewById(R.id.minus);
            Value = itemView.findViewById(R.id.itemCount);
            Product = itemView.findViewById(R.id.txt_product_name);
            Price = itemView.findViewById(R.id.txt_price);
            Delete=itemView.findViewById(R.id.delete_btn);
       

//            Add.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view) {
//                    int newValue = 1 + Integer.parseInt(Value.getText().toString());
//                    Value.setText(Integer.toString(newValue));
//
//                }
//             });
//
//            Minus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int newValue = Integer.parseInt(Value.getText().toString())-1;
//                    Value.setText(Integer.toString(newValue));
//                }
//            });










    }
}}
