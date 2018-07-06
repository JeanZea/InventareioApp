package com.isil.inventario.activities.products.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.adapters.AdapterCompanyProduct;

public class ProductsActivity extends AppCompatActivity {

    public static int empresaActual = -1;
    ListView listproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        listproduct = findViewById(R.id.lst_Products);

        AdapterCompanyProduct adapter = new AdapterCompanyProduct(this, MenuActivity.empresas);

        listproduct.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_returnProducts);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductsActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });
    }
}
