package com.isil.inventario.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.isil.inventario.activities.company.activities.EditEmpresa;
import com.isil.inventario.activities.company.activities.EmpresaActivity;
import com.isil.inventario.activities.company.activities.EmpresaDetails;
import com.isil.inventario.R;
import com.isil.inventario.entities.Empresa;

import java.util.ArrayList;

public class AdapterEmpresa extends ArrayAdapter {

    private Context context;
    private ArrayList<Empresa> empresas;

    public AdapterEmpresa(Context context, ArrayList<Empresa> empresas){
        super(context, 0, empresas);
        this.context = context;
        this.empresas = empresas;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.adapter_empresa, null);

        TextView nameEm = convertView.findViewById(R.id.txt_nameEm);
        TextView categoriaEm = convertView.findViewById(R.id.txt_Categoria);
        Button btnEdit = convertView.findViewById(R.id.btn_EditEm);
        Button btnTrash = convertView.findViewById(R.id.btn_trashEm);

        final Empresa empresa = empresas.get(position);

        nameEm.setText(empresa.getNombreEmpresa());
        categoriaEm.setText(empresa.getCategorias() + "");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,EmpresaDetails.class);
                intent.putExtra("indice", position);
                context.startActivity(intent);
            }
        });

        btnTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Advertencia")
                        .setMessage("Estas seguro que quieres eliminar esta Empresa?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                empresas.remove(position);
                                EmpresaActivity.lista.setAdapter(EmpresaActivity.lista.getAdapter());
                            }
                        })
                        .setNegativeButton("Cancel", null);
                Dialog adv = builder.create();
                adv.show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditEmpresa.class);
                i.putExtra("position", position);
                context.startActivity(i);
            }
        });

        return convertView;
    }

}
