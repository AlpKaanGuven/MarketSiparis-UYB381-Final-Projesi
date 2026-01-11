package com.example.marketsiparis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Product> list;
    Runnable updateTotal;

    public CartAdapter(ArrayList<Product> list, Runnable updateTotal) {
        this.list = list;
        this.updateTotal = updateTotal;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvQuantity;
        Button btnPlus, btnMinus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.text_quantity);
            btnPlus = itemView.findViewById(R.id.button_increase);
            btnMinus = itemView.findViewById(R.id.button_decrease);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);

        holder.tvName.setText(product.name);
        holder.tvQuantity.setText(String.valueOf(product.quantity));

        holder.btnPlus.setOnClickListener(v -> {
            product.quantity++;
            holder.tvQuantity.setText(String.valueOf(product.quantity));
            updateTotal.run();
            holder.btnPlus.setText("+");
        });

        holder.btnMinus.setOnClickListener(v -> {
            if (product.quantity > 1) {
                product.quantity--;
                holder.tvQuantity.setText(String.valueOf(product.quantity));
                updateTotal.run();
                holder.btnMinus.setText("-");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
