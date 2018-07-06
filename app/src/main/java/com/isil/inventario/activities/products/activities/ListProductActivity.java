package com.isil.inventario.activities.products.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.adapters.AdapterProduct;

public class ListProductActivity extends AppCompatActivity {

    public static ListView listaproductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListProductActivity.this, AddProductActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab_return = (FloatingActionButton) findViewById(R.id.fab_return);
        fab_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListProductActivity.this, ProductsActivity.class);
                startActivity(i);
            }
        });




        listaproductos = findViewById(R.id.lst_listproducts);

        AdapterProduct adapterProduct = new AdapterProduct(this, MenuActivity.empresas.get(ProductsActivity.empresaActual).getProducts());

        listaproductos.setAdapter(adapterProduct);
    }

}
