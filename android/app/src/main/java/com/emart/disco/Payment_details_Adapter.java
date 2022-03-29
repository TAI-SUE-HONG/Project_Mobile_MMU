package com.emart.disco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Payment;

public class Payment_details_Adapter extends RecyclerView.Adapter<Payment_details_Adapter.Viewholder> {
    Context context;
    List<Payment> PaymentList;

    public Payment_details_Adapter(Context context) {
        this.context = context;
        notifyDataSetChanged();
    }

    public void setPaymentDetail(List<Payment> PaymentList) {
        this.PaymentList = PaymentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Payment_details_Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.activity_order_history2, parent, false);
        return new Payment_details_Adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Payment_details_Adapter.Viewholder holder, int position) {
        //assigning values to view created in the recycleview layout file
        //all based on the position of the recycleview
        holder.title.setText(PaymentList.get(position).getTitle());
        holder.value.setText(PaymentList.get(position).getValue());
    }

    @Override //the number of items in cart
    public int getItemCount() {
        return PaymentList == null ? 0 : PaymentList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        //grabbing layout from activity_payment_details2

        TextView title;
        TextView value;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_payment_detail_title2);
            value = itemView.findViewById(R.id.tv_payment_detail_value2);
        }
    }
}
