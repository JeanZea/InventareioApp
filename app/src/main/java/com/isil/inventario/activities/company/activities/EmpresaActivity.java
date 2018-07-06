package com.isil.inventario.activities.company.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.adapters.AdapterEmpresa;

public class EmpresaActivity extends AppCompatActivity {

    public static ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmpresaActivity.this, NuevaEmpresa.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmpresaActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        lista = findViewById(R.id.ltv_empresas);

        AdapterEmpresa adaptador = new AdapterEmpresa(this, MenuActivity.empresas);

        lista.setAdapter(adaptador);


    }

}
