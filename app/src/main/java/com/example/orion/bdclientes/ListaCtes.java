package com.example.orion.bdclientes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaCtes extends AppCompatActivity {

    @BindView(R.id.lvltvctes)
    ListView lvltvctes;
    DBClientes objCtes;
    SQLiteDatabase DB;
    ArrayAdapter<String> valores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ctes);
        ButterKnife.bind(this);

        valores=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        objCtes= new DBClientes(this, "CURSO", null,1);

        DB=objCtes.getReadableDatabase();

        Cursor c = DB.rawQuery("SELECT * FROM clientes ORDER BY nombre", null);
        if( c.moveToFirst() ){
            do{
                valores.add(c.getString(1)+" "+c.getString(4));
            }while(c.moveToNext());
            lvltvctes.setAdapter(valores);
        }else{
            Toast.makeText(getApplicationContext(), "No Existen Registros", Toast.LENGTH_SHORT).show();
            this.finish();
            }
    }
}
