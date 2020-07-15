package com.example.orion.bdclientes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Clientes extends AppCompatActivity {

    @BindView(R.id.edtnom)
    EditText edtnom;

    @BindView(R.id.edtdir)
    EditText edtdir;

    @BindView(R.id.rdbmas)
    RadioButton rdbmas;

    @BindView(R.id.rdbfem)
    RadioButton rdbfem;

    @BindView(R.id.spnedo)
    Spinner spnedo;

    @BindView(R.id.edttel)
    EditText edttel;

    @BindView(R.id.edtedad)
    EditText edtedad;

    @BindView(R.id.edtemail)
    EditText edtemail;

    String[] estados={"Guanajuato", "Michoacan", "Queretaro", "Jalisco", "Sonora"};
    ArrayAdapter modelo;

    DBClientes objBD;
    SQLiteDatabase BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        ButterKnife.bind(this);

        modelo=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,estados);
        spnedo.setAdapter(modelo);

        objBD=new DBClientes(this,"CURSO",null,1);
        BD=objBD.getWritableDatabase();
    }

    @OnClick(R.id.btnGuardar)
    public void guarda(){
        String nom=edtnom.getText().toString();
        String dir=edtdir.getText().toString();
        String sex="";
        if(rdbmas.isSelected())sex=rdbmas.getText().toString();
        if(rdbfem.isSelected())sex=rdbfem.getText().toString();
        String edo=spnedo.getSelectedItem().toString();
        String eda=edtedad.getText().toString();
        String tel=edttel.getText().toString();
        String email= edtemail.getText().toString();

        String Qry = "INSERT INTO clientes(nombre,direccion,sexo,estado,edad,telefono,email) VALUES('"+nom+"','"+dir+"','"+sex+"','"+edo+"',"+Integer.parseInt(eda)+",'"+tel+"','"+email+"') ";
        BD.execSQL(Qry);
        Toast.makeText(this, "Cliente Insertado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.itmverctes){
            //Llamar nueva Activity
            Intent intent=new Intent(this, ListaCtes.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
