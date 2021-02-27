package com.example.ejercicio3parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //::: Variable globales :::::::::::::::::::::::::::::
    private  EditText Nombre;
    private  EditText Apellido;
    private  EditText Cargo;
    private  EditText horas;
    //:::::::: Creando Vectores ::::::::::::::::::::::::
    String[] nombre     = new String[3];
    String[] apellido   = new String[3];
    String[] cargo      = new String[3];
    String[] hora       = new String[3];
       int contador =   0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Asignando los valores de los editText a las variables globales
        Nombre      =   (EditText)findViewById(R.id.editTextNombre);
        Apellido    =   (EditText)findViewById(R.id.editTextApellido);
        Cargo       =   (EditText)findViewById(R.id.editTextCargo);
        horas       =   (EditText)findViewById(R.id.editTextHoras);
    }
 //:::::: Creando Funcion para la activitity Dos :::::::::::::::::::::::::
    public void SegundaPantalla(View view)
    {
        if(Integer.parseInt(horas.getText().toString()) <= 0)
        {
            Toast.makeText(this, "NO SE PERMITE HORAS NEGATIVAS NI NULAS, INGRESE DE NUEVO", Toast.LENGTH_LONG).show();
        }
       else
        {
            if(contador==3)
            {
                /*Intent : es un objeto de mensajería que puedes usar para solicitar una acción de otro componente de una app.
        Si bien las intents facilitan la comunicación entre componentes de varias formas*/

                Bundle bundle = new Bundle();
                bundle.putStringArray("arrayDatos", new String[]{nombre[0],nombre[1],nombre[2]});
                bundle.putStringArray("arrayDatos2", new String[]{apellido[0],apellido[1],apellido[2]});
                bundle.putStringArray("arrayDatos3", new String[]{cargo[0],cargo[1],cargo[2]});
                bundle.putStringArray("arrayDatos4", new String[]{hora[0],hora[1],hora[2]});
                Intent intent = new Intent(MainActivity.this, Resultados.class);
                intent.putExtras(bundle);
                startActivity(intent);
           }
            else
            {
                //Agregando los datos al arreglo ::::::::::::::::::::::
                nombre  [contador]   =    Nombre.getText().toString();
                apellido[contador]   =    Apellido.getText().toString();
                cargo   [contador]   =    (Cargo.getText().toString()).toLowerCase();
                hora    [contador]   =    horas.getText().toString();

                contador++;
                Toast.makeText(this, "Personas Registradas: "+contador, Toast.LENGTH_SHORT).show();
            }


        }


    }
}
