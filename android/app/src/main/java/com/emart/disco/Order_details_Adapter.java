package com.emart.disco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Order_details_Adapter extends RecyclerView.Adapter<Order_details_Adapter.Viewholder> {
    Context context;
    ArrayList<Order> orderList;

    public Order_details_Adapter(Context context, ArrayList<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order_details2, parent, false);
        return new Order_details_Adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        //assigning values to view created in the recycleview layout file
        //all based on the position of the recycleview
        holder.Title.setText(orderList.get(position).getTitle());
        holder.Value.setText(orderList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        //grabbing layout from activity_order_history2

        TextView Title;
        TextView Value;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.tv_order_detail_title);
            Value = itemView.findViewById(R.id.tv_order_detail_value);
        }
    }
}
