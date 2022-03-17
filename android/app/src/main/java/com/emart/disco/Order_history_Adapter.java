package com.emart.disco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Order_history_Adapter extends RecyclerView.Adapter<Order_history_Adapter.Viewholder> {
    Context context;
    ArrayList<Cart_test> cartTestList;

    public Order_history_Adapter(Context context, ArrayList<Cart_test> cartTestList) {
        this.context = context;
        this.cartTestList = cartTestList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order_history2, parent, false);
        return new Order_history_Adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        //assigning values to view created in the recycleview layout file
        //all based on the position of the recycleview
        holder.Date.setText(Integer.toString(cartTestList.get(position).getDate()));
        holder.Description.setText(cartTestList.get(position).getDescription());
    }

    @Override //the number of items in cart
    public int getItemCount() {
        return cartTestList == null ? 0 : cartTestList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        //grabbing layout from activity_order_history2

        TextView Date;
        TextView Description;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Date = itemView.findViewById(R.id.order_date);
            Description = itemView.findViewById(R.id.order_summary);
        }
    }
}
