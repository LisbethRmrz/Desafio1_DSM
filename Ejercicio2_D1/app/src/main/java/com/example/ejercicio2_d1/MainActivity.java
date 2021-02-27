package com.example.ejercicio2_d1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.lang.String;
import java.util.Arrays;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private TextView indicacion;
    private TextView c1;
    private TextView c2;
    private TextView c3;
    private TextView c4;
    private TextView nulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.votos);
        c1 = (TextView)findViewById(R.id.resultado);
        c2 = (TextView)findViewById(R.id.resultado2);
        c3 = (TextView)findViewById(R.id.resultado3);
        c4 = (TextView)findViewById(R.id.resultado4);
        nulos = (TextView)findViewById(R.id.nulo);

    }

    public void votos (View view)
    {
        String datos = et.getText().toString();

        String[] parts = datos.split("\\,");

        int total = parts.length;
        int votoc1=0;
        int votoc2=0;
        int votoc3=0;
        int votoc4=0;
        int cnulo=0;

        List<String> lista = Arrays.asList(parts);

        for (String part : lista)
        {
            if (part.equals("1"))
            {
                votoc1++;
            }
            else if (part.equals("2"))
            {
                votoc2++;
            }
            else if (part.equals("3"))
            {
                votoc3++;
            }
            else if (part.equals("4"))
            {
                votoc4++;
            }
            else
            {
                cnulo++;
            }
        }

        double porcentaje1 = (votoc1*100/total);
        double porcentaje2 = (votoc2*100/total);
        double porcentaje3 = (votoc3*100/total);
        double porcentaje4 = (votoc4*100/total);
        double porcentaje5 = (cnulo*100/total);


        c1.setText("Candidato 1: " + votoc1 + " votos = " + porcentaje1 + "%");
        c2.setText("Candidato 2: " + votoc2 + " votos = " + porcentaje2 + "%");
        c3.setText("Candidato 3: " + votoc3 + " votos = " + porcentaje3 + "%");
        c4.setText("Candidato 4: " + votoc4 + " votos = " + porcentaje4 + "%");
        nulos.setText("Votos Nulos: " + cnulo + " votos = " + porcentaje5 + "%");

    }
}