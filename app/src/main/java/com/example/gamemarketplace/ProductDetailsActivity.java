package com.example.gamemarketplace;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);


        // Get the intent that started this activity
        Intent intent = getIntent();

        // Retrieve the product from the intent extras
        Product product = (Product) intent.getSerializableExtra("product");

        if (product != null) {
            // Now you can use the product object to populate your UI elements.
            TextView productNameTextView = findViewById(R.id.productTitle);
            ImageView productImageView = findViewById(R.id.productImage);

            productNameTextView.setText(product.getTitle());
            productImageView.setImageResource(product.getImageResourceId());
        } else {
            // Handle the case where product is null...
        }


        //toolbar and other elements
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button downloadButton = findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaymentOptionsActivity.class);
                startActivity(intent);
            }
        });

        Button previewButton = findViewById(R.id.previewButton);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);
                startActivity(intent);
            }
        });



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}

