package com.isil.inventario.activities.company.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.entities.Categoria;

public class EditEmpresa extends AppCompatActivity {
    EditText newTitle, newDescripcion;
    TextView titleEmpresa;

    Spinner spnNewCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_empresa);

        newTitle = findViewById(R.id.txt_newTitle);
        newDescripcion = findViewById(R.id.txtDescripcion);

        spnNewCategoria = findViewById(R.id.spn_EditEmpresa);

        spnNewCategoria.setAdapter(new ArrayAdapter<Categoria>(this, R.layout.support_simple_spinner_dropdown_item, Categoria.values()));

        titleEmpresa = findViewById(R.id.txtTituloEm);

        Bundle posicion = getIntent().getExtras();

        final int position = posicion.getInt("position");

        newTitle.setText(MenuActivity.empresas.get(position).getNombreEmpresa());
        newDescripcion.setText(MenuActivity.empresas.get(position).getDescripcionEmpresa());

        Button btnEditDatos = (Button) findViewById(R.id.btn_guardarEdit);

        btnEditDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuActivity.empresas.get(position).setNombreEmpresa(newTitle.getText().toString());
                MenuActivity.empresas.get(position).setDescripcionEmpresa(newDescripcion.getText().toString());
                MenuActivity.empresas.get(position).setCategorias((Categoria) spnNewCategoria.getSelectedItem());

                Intent i = new Intent(EditEmpresa.this, EmpresaActivity.class);
                startActivity(i);
            }
        });

        Button retornar = findViewById(R.id.btn_return);

        retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditEmpresa.this, EmpresaActivity.class);
                startActivity(i);
            }
        });

    }


}
