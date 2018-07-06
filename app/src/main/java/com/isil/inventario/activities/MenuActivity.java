package com.isil.inventario.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.isil.inventario.activities.category.activities.CategoryActivity;
import com.isil.inventario.R;
import com.isil.inventario.activities.company.activities.EmpresaActivity;
import com.isil.inventario.activities.products.activities.ProductsActivity;
import com.isil.inventario.entities.Categoria;
import com.isil.inventario.entities.Empresa;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static ArrayList<Empresa> empresas = new ArrayList<>();

    Empresa empresa1 = new Empresa("Ripley", "Somos una empresa dedicada a la venta de todo tipo de profuctos.", Categoria.ENUM1);
    Empresa empresa2 = new Empresa("Tottus", "Somos una empresa dedicada a la venta de todo tipo de productos", Categoria.ENUM2);
    Empresa empresa3 = new Empresa("Metro ", "Somos una empresa dedicada a la venta de todo tipo de productos", Categoria.ENUM5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if (empresas.size() == 0){
            empresas.add(empresa1);
            empresas.add(empresa2);
            empresas.add(empresa3);
        }


        Button btnEmpresas = findViewById(R.id.btnEmpresas);

        btnEmpresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, EmpresaActivity.class);
                startActivity(i);
            }
        });

        Button btnProductos = findViewById(R.id.btnProductos);

        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ProductsActivity.class);
                startActivity(i);
            }
        });

        Button btnCategorias = findViewById(R.id.btnCategoria);
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, CategoryActivity.class);
                startActivity(i);
            }
        });

    }

}
