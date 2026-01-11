package com.example.marketsiparis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {

    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvTotal = findViewById(R.id.tvTotal);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        Button btnBack = findViewById(R.id.btnBack);
        RecyclerView rvCart = findViewById(R.id.rvCart);

        rvCart.setLayoutManager(new LinearLayoutManager(this));

        CartAdapter adapter = new CartAdapter(MainActivity.cart, this::updateTotal);
        rvCart.setAdapter(adapter);

        updateTotal();

        btnConfirm.setOnClickListener(v -> {
            Toast.makeText(this, "Sepetiniz onaylandı, teşekkürler", Toast.LENGTH_LONG).show();
            MainActivity.cart.clear();

            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        });

        btnBack.setOnClickListener(v -> finish());
    }

    private void updateTotal() {
        double total = 0;
        for (Product p : MainActivity.cart) {
            total += p.price * p.quantity;
        }
        tvTotal.setText("Toplam: ₺" + total);
    }
}
