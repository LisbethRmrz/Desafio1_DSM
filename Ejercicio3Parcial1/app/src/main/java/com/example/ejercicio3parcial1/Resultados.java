package com.example.ejercicio3parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Resultados extends AppCompatActivity {
    //:::::::: Varibles Globales:::::::::::::::
    private TextView tvNombre;
    private TextView tvApellido;
    private TextView tvCargo;
    private TextView tvHoras;
    private TextView tvISSS;
    private TextView tvAFP;
    private TextView tvRenta;
    private TextView Salario;
    private TextView tvbono;
    private TextView tvSalarioMaximo;
    private TextView tvSalarioMinimo;
    private TextView tvCantidad;
    double SalarioBruto=0,isss=0,afp=0,renta=0,SalarioNeto=0,bono=0,SalarioMax=0,SalarioMin=0;
    boolean banderadeorden=false;
    int valorhoras=0,indicedelmayorsalario=0,indicedelmenorsalario=0,contadormayordetrecientos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //::::: Agregar las Id de los textview:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        tvNombre        =  (TextView) findViewById(R.id.Nombretxt);
        tvApellido      =  (TextView) findViewById(R.id.Apellidotxt);
        tvCargo         =  (TextView) findViewById(R.id.Cargotxt);
        tvHoras         =  (TextView) findViewById(R.id.Horastxt);
        tvISSS          =  (TextView) findViewById(R.id.ISSStxt);
        Salario         =  (TextView) findViewById(R.id.Netotxt);
        tvAFP           =  (TextView) findViewById(R.id.AFPtxt);
        tvRenta         =  (TextView) findViewById(R.id.Rentatxt);
        tvbono          =  (TextView) findViewById(R.id.BonoTxt);
        tvSalarioMaximo =  (TextView) findViewById(R.id.Mayortxt);
        tvSalarioMinimo =  (TextView) findViewById(R.id.Menortxt);
        tvCantidad      =  (TextView) findViewById(R.id.Cantidadtxt);

        /*Bundle : Los paquetes se utilizan generalmente para pasar datos entre varias actividades de Android*/
        Bundle bundle = getIntent().getExtras();//creando un objeto bundle para traer los datos de la actividad mendiante Intent
        //String nombre=bundle.getString("Nombre");

       // Bundle bundle = this.getIntent().getExtras();
        String[] Nombre = bundle.getStringArray("arrayDatos");
        String[] Apellido = bundle.getStringArray("arrayDatos2");
        String[] Cargo = bundle.getStringArray("arrayDatos3");
        String[] Horas = bundle.getStringArray("arrayDatos4");
        String nombres="";
        String apellidos="";
        String cargos="";
        String horas="";
        String Isss="";
        String Renta="";
        String Afp ="";
        String SaNeto ="";
        String Bonos ="";

        nombres     += "Nombre" + '\n';
        apellidos   +=  "Apellido" + '\n';
        cargos      += "Cargo" + '\n';
        horas       +=  "Horas" + '\n';
        Isss        +=  "ISSS" + '\n';
        Renta       +=  "Renta" + '\n';
        Afp         +=  "AFP" + '\n';
        SaNeto      +=  "Salario Neto" + '\n';
        Bonos      +=  "Bono" + '\n';

        if(Cargo[0].equals("gerente") && Cargo[1].equals("asistente") && Cargo[2].equals("secretaria"))
        {
            banderadeorden =true;
        }
        for(int i=0;i<=2;i++)
        {
            isss=0;
            renta=0;
            afp=0;
            SalarioNeto =0;
            bono=0;
            nombres     +=  Nombre[i] + '\n';
            apellidos   +=  Apellido[i] + '\n';
            cargos      +=  Cargo[i] + '\n';
            horas       +=  Horas[i] + '\n';

            valorhoras = Integer.parseInt(Horas[i]);
            if(Integer.parseInt(Horas[i])<=160)
            {
                SalarioBruto = valorhoras*9.75;
            }
            if(Integer.parseInt(Horas[i])>160)
            {
                SalarioBruto = 160*9.75;
                SalarioBruto = SalarioBruto + (valorhoras-160)*11.50;
            }
            isss        =   Math.round( (SalarioBruto*0.0525)*100.0)/100;
            renta       =   Math.round((SalarioBruto*0.0688)*100.0)/100;
            afp         =   Math.round((SalarioBruto*0.1)*100.0)/100;
            SalarioNeto =   Math.round((SalarioBruto - (isss+renta+afp))*100)/100;
            //Toast.makeText(this, Cargo[i], Toast.LENGTH_LONG).show();
            if(banderadeorden == true)
            {
                String IssS     = valueOf(isss);
                String RenTa    = valueOf(renta);
                String AfP      = valueOf(afp);
                String Sneto    = valueOf(SalarioNeto);
                String bOnos    = valueOf(bono);
                Isss       +=  IssS + '\n';
                Renta       +=  RenTa + '\n';
                Afp       +=  AfP + '\n';
                SaNeto       +=  Sneto + '\n';
                Bonos      +=  "N0 HAY BONOS" + '\n';
            }
            else
            {
                switch(Cargo[i])
                {
                    case "gerente":
                        bono =  Math.round((SalarioNeto*0.1)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    case "asistente":
                        bono = Math.round((SalarioNeto*0.05)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    case "secretaria":
                        bono = Math.round((SalarioNeto*0.03)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                    default:
                        bono = Math.round((SalarioNeto*0.02)*100)/100;
                        SalarioNeto = SalarioNeto+bono;
                        break;
                }
                String IssS     = valueOf(isss);
                String RenTa    = valueOf(renta);
                String AfP      = valueOf(afp);
                String Sneto    = valueOf(SalarioNeto);
                String bOnos    = valueOf(bono);
                Isss       +=  IssS + '\n';
                Renta       +=  RenTa + '\n';
                Afp       +=  AfP + '\n';
                SaNeto       +=  Sneto + '\n';
                Bonos      +=  bOnos + '\n';
            }
            //::::::::: Logica para calcular el salario max y min
            if(i==0)
            {
                indicedelmayorsalario = i;
                SalarioMax=SalarioNeto;
                SalarioMin=SalarioNeto;
            }
            if(i!=0)
            {
                if(SalarioNeto < SalarioMax)
                {
                    SalarioMin = SalarioNeto;
                    indicedelmenorsalario = i;//Guardo el indice menor para luego mostrar el nombre del vector Nombre[i]
                }
                else
                {
                    SalarioMax = SalarioNeto;
                    indicedelmayorsalario = i;//Guardo el indice mayor para luego mostrar el nombre del vector Nombre[i]
                }
            }
            //:::::: Calculando cuantos ganan mas de $300 pesos
            if(SalarioNeto>300)
            {
                contadormayordetrecientos++;
            }
           //:::::::::::: Mostrando En los TxtView
            tvNombre.setText(nombres);
            tvApellido.setText(apellidos);
            tvCargo.setText(cargos);
            tvHoras.setText(horas);
            tvISSS.setText(Isss);
            tvAFP.setText(Afp);
            tvRenta.setText(Renta);
            Salario.setText(SaNeto);
            tvbono.setText(Bonos);
        }
        String ContadorMayorTRE = valueOf(contadormayordetrecientos);
        String Smaximo    = valueOf(Nombre[indicedelmayorsalario]);
        String Sminimo    = valueOf(Nombre[indicedelmenorsalario]);
        tvSalarioMaximo.setText(Smaximo);
        tvSalarioMinimo.setText(Sminimo);
        tvCantidad.setText(ContadorMayorTRE);


    }
    public void finalizar(View view)
    {
        Intent intent = new Intent(Resultados.this, MainActivity.class);
        //intent.putExtras(bundle);
        startActivity(intent);
    }
}
