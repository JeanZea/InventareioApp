package com.isil.inventario.activities.company.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;

public class EmpresaDetails extends AppCompatActivity {
    TextView nameDetails, categoriesDetails, descripcionDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_details);

        nameDetails = findViewById(R.id.txt_nameDescripcion);
        categoriesDetails = findViewById(R.id.txt_categoriesDescripcion);
        descripcionDetails = findViewById(R.id.txt_descripcionDes);

        Bundle indices = getIntent().getExtras();

        int index = indices.getInt("indice");

        nameDetails.setText(MenuActivity.empresas.get(index).getNombreEmpresa());
        categoriesDetails.setText(MenuActivity.empresas.get(index).getCategorias() + "");
        descripcionDetails.setText(MenuActivity.empresas.get(index).getDescripcionEmpresa());

        Button regresarView = findViewById(R.id.btnRegresarView);

        regresarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EmpresaDetails.this, EmpresaActivity.class);
                startActivity(i);
            }
        });

    }
}
