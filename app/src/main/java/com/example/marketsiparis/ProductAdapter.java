package com.example.marketsiparis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    public interface OnAddClickListener {
        void onAdd(Product product);
    }

    private final List<Product> products;
    private final OnAddClickListener listener;

    public ProductAdapter(List<Product> products, OnAddClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        Button btnAdd;

        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
            tvPrice = view.findViewById(R.id.tvPrice);
            btnAdd = view.findViewById(R.id.btnAdd);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.tvName.setText(product.name);
        holder.tvPrice.setText("₺" + product.price);
        holder.btnAdd.setOnClickListener(v -> listener.onAdd(product));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}