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

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.activities.company.activities.EmpresaActivity;
import com.isil.inventario.activities.company.activities.EmpresaDetails;
import com.isil.inventario.activities.products.activities.ListProductActivity;
import com.isil.inventario.entities.Product;

import java.util.ArrayList;

public class AdapterProduct extends ArrayAdapter {
    Context context;
    ArrayList<Product> products;


    public AdapterProduct(@NonNull Context context, ArrayList<Product> products) {
        super(context, 0, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_product, null);

        TextView nameProduct = convertView.findViewById(R.id.lbl_nameProduct);
        TextView instock = convertView.findViewById(R.id.lbl_instock);
        Button btn_delete = convertView.findViewById(R.id.btn_deleteProduct);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Advertencia")
                        .setMessage("Estas seguro que quieres eliminar esta Producto?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                products.remove(position);
                                ListProductActivity.listaproductos.setAdapter(ListProductActivity.listaproductos.getAdapter());
                            }
                        })
                        .setNegativeButton("Cancel", null);
                Dialog adv = builder.create();
                adv.show();
            }
        });


        nameProduct.setText(products.get(position).getNameProduct());
        instock.setText(products.get(position).getStockProduct() + "");

        return convertView;
    }
}
