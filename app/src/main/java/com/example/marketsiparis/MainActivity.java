package com.example.marketsiparis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Product> cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAddMilk).setOnClickListener(v ->
                addToCart("Süt", 25)
        );

        findViewById(R.id.btnAddBread).setOnClickListener(v ->
                addToCart("Ekmek", 10)
        );

        findViewById(R.id.btnAddEgg).setOnClickListener(v ->
                addToCart("Yumurta", 60)
        );

        findViewById(R.id.btnGoCart).setOnClickListener(v -> {
            if (cart.isEmpty()) {
                Toast.makeText(this, "Sepet boş", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, CartActivity.class));
            }
        });
    }

    private void addToCart(String name, double price) {
        for (Product p : cart) {
            if (p.name.equals(name)) {
                p.quantity++;
                return;
            }
        }
        cart.add(new Product(name, price));
    }
}
