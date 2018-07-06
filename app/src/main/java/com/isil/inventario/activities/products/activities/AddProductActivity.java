package com.isil.inventario.activities.products.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isil.inventario.R;
import com.isil.inventario.activities.MenuActivity;
import com.isil.inventario.entities.Product;

public class AddProductActivity extends AppCompatActivity {

    EditText addname, addprice, addstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        addname = findViewById(R.id.txt_addproductname);
        addstock = findViewById(R.id.txt_addstockproduct);
        addprice = findViewById(R.id.txt_addpriceproduct);

        Button btn_addproduct = findViewById(R.id.btn_Addproduct);

        btn_addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addname.getText().toString().isEmpty() || addstock.getText().toString().isEmpty() || addprice.getText().toString().isEmpty()){
                    Toast.makeText(AddProductActivity.this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }else {
                    Product product = new Product(addname.getText().toString(), Integer.parseInt(addstock.getText().toString()), Double.parseDouble(addprice.getText().toString()), MenuActivity.empresas);
                    MenuActivity.empresas.get(ProductsActivity.empresaActual).getProducts().add(product);
                    Intent i = new Intent(AddProductActivity.this, ListProductActivity.class);
                    startActivity(i);
                }

            }
        });

    }
}
