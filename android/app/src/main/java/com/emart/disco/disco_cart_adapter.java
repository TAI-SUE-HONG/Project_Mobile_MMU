package com.emart.disco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Cart;

public class disco_cart_adapter extends RecyclerView.Adapter<disco_cart_adapter.Viewholder> {
    Context context;
    ArrayList<Cart_test> CartList;

    public disco_cart_adapter(Context context, ArrayList<Cart_test> CartList) {
        this.context = context;
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
        holder.Value.setText(Integer.toString(CartList.get(position).getQuantity()));
    }

    @Override //the number of items in cart
    public int getItemCount() {
        return CartList == null ? 0 : CartList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        //grabbing layout from order_history_adapter

        Button Add, Minus;
        TextView Value;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Add = itemView.findViewById(R.id.add);
            Minus = itemView.findViewById(R.id.minus);
            Value = itemView.findViewById(R.id.itemCount);
            Add.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int newValue = 1 + Integer.parseInt(Value.getText().toString());
                    Value.setText(Integer.toString(newValue));
                }
             });

            Minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int newValue = Integer.parseInt(Value.getText().toString())-1;
                    Value.setText(Integer.toString(newValue));
                }
            });


    }
}}
