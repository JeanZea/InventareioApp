package com.isil.inventario.activities.category.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.adapters.AdapterEmpresa;
import com.isil.inventario.entities.Categoria;
import com.isil.inventario.entities.Empresa;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Empresa> porempresa = new ArrayList<>();

    Spinner categoria;

    ListView listEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoria = findViewById(R.id.spn_search);

        categoria.setAdapter(new ArrayAdapter<Categoria>(this, R.layout.support_simple_spinner_dropdown_item, Categoria.values()));

        listEmpresa = findViewById(R.id.lst_porCategoria);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_cat);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CategoryActivity.this, MenuActivity.class);
                startActivity(i);


            }
        });

        final AdapterEmpresa adaptador = new AdapterEmpresa(this,porempresa);



        categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                porempresa.clear();
                for (Empresa e: MenuActivity.empresas){
                    if (e.getCategorias().equals(categoria.getSelectedItem())){
                       porempresa.add(e);
                    }
                }

                //porempresa = new ArrayList<>();
                listEmpresa.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
