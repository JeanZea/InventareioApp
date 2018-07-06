package com.isil.inventario.activities.company.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.entities.Categoria;
import com.isil.inventario.entities.Empresa;

import java.util.ArrayList;

public class NuevaEmpresa extends AppCompatActivity {
    EditText nombreEmpresa, descripcionEmpresa;
    Spinner spnCategoria;

    ArrayList<Categoria> categorias = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_empresa);

        nombreEmpresa = findViewById(R.id.txt_nombreEmpresa);
        descripcionEmpresa = findViewById(R.id.txt_descripcionEmpresa);

        spnCategoria = findViewById(R.id.spn_Categoria);

        spnCategoria.setAdapter(new ArrayAdapter<Categoria>(this, R.layout.support_simple_spinner_dropdown_item, Categoria.values()));

        Button btnAgregarEmpresa = findViewById(R.id.btn_agregarEmpresa);

        btnAgregarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nombreEmpresa.getText().toString().isEmpty() || descripcionEmpresa.getText().toString().isEmpty()){
                    Toast.makeText(NuevaEmpresa.this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }else {
                    Empresa empresa = new Empresa(nombreEmpresa.getText().toString(), descripcionEmpresa.getText().toString(), (Categoria) spnCategoria.getSelectedItem());

                    MenuActivity.empresas.add(empresa);

                    Intent i = new Intent(NuevaEmpresa.this,EmpresaActivity.class);
                    startActivity(i);
                }

            }
        });

    }
}
