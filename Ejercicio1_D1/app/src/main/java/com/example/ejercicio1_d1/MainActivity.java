package com.example.ejercicio1_d1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.a);
        et2 = (EditText)findViewById(R.id.b);
        et3 = (EditText)findViewById(R.id.c);
        tv1 = (TextView)findViewById(R.id.raiz1);
        tv2 = (TextView)findViewById(R.id.raiz2);
    }

    public void estatus(View view)
    {
    String a_string = et1.getText().toString();
    String b_string = et2.getText().toString();
    String c_string = et3.getText().toString();

    double a_double = Double.parseDouble(a_string);
    double b_double = Double.parseDouble(b_string);
    double c_double = Double.parseDouble(c_string);

    double bcuad = Math.pow(b_double,2);
    double resta = (bcuad - 4*a_double*c_double);
    double raizcuad = Math.sqrt(resta);
    double denominador = (2*a_double);
    double b = (0-b_double);
    double num1 = (b + raizcuad);
    double num2 = (b - raizcuad);
    double raiz1 = (num1/denominador);
    double raiz2 = (num2/denominador);

        BigDecimal bd1 = new BigDecimal(raiz1).setScale(2, RoundingMode.HALF_UP);
        double respuesta1 = bd1.doubleValue();
        BigDecimal bd2 = new BigDecimal(raiz2).setScale(2, RoundingMode.HALF_UP);
        double respuesta2 = bd2.doubleValue();

    //double respuesta1 = Math.round(raiz1*100)/100;
    //double respuesta2 = Math.round(raiz2*100)/100;

    tv1.setText("X1: " + respuesta1);
    tv2.setText("X2: " + respuesta2);

    }
}