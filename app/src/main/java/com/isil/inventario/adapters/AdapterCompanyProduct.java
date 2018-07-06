package com.isil.inventario.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.isil.inventario.R;
import com.isil.inventario.activities.products.activities.ListProductActivity;
import com.isil.inventario.activities.products.activities.ProductsActivity;
import com.isil.inventario.entities.Empresa;

import java.util.ArrayList;

public class AdapterCompanyProduct extends ArrayAdapter {
    private Context context;
    private ArrayList<Empresa> empresas;

    public AdapterCompanyProduct(@NonNull Context context, ArrayList<Empresa> empresas) {
        super(context, 0, empresas);
        this.context = context;
        this.empresas = empresas;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.adapter_empresa_products, null);

        TextView nameCompanyProducts = convertView.findViewById(R.id.txt_nameEmpresaProduct);
        nameCompanyProducts.setText(empresas.get(position).getNombreEmpresa());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ListProductActivity.class);
                //i.putExtra("position", position);
                ProductsActivity.empresaActual = position;
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
