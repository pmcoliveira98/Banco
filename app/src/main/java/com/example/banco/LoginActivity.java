package com.example.banco;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdicionar, buttonSubtrair,
            buttonPonto, buttonLimpar, buttonFinalizar;
    EditText EditText;
    TextView TextView;

    float valor;
    float saldo =1000;
    boolean adicionar, subtrair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPonto = (Button) findViewById(R.id.buttonPonto);
        buttonAdicionar = (Button) findViewById(R.id.buttonadicionar);
        buttonSubtrair = (Button) findViewById(R.id.buttonsub);
        buttonLimpar = (Button) findViewById(R.id.buttonLimpar);
        buttonFinalizar = (Button) findViewById(R.id.buttonFinalizar);
        EditText = (EditText) findViewById(R.id.edt1);
        TextView = (TextView) findViewById(R.id.edt);
//________________________________________________________________________________________________//
        TextView edt = (TextView) findViewById(R.id.edt);
        edt.setText("O seu saldo é " + saldo + "€");


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "0");
            }
        });
//________________________________________________________________________________________________//
        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (EditText == null) {
                    EditText.setText("");
                } else {
                    valor = Float.parseFloat(EditText.getText() + "");
                    adicionar = true;
                    EditText.setText(null);
                }
            }
        });

        buttonSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor = Float.parseFloat(EditText.getText() + "");
                subtrair = true;
                EditText.setText(null);
            }
        });


//________________________________________________________________________________________________//
        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (adicionar == true) {
                    EditText.setText("");
                    TextView edt2 = (TextView) findViewById(R.id.edt2);
                    edt2.setText("O seu saldo era " + saldo + "€ e depositou " + valor + "€");
                    saldo += valor;
                    adicionar = false;
                    TextView edt = (TextView) findViewById(R.id.edt);
                    edt.setText("O seu saldo é " + saldo + "€");
                }


                if (subtrair == true) {
                    EditText.setText("");
                    TextView edt2 = (TextView) findViewById(R.id.edt2);
                    edt2.setText("O seu saldo era " + saldo + "€ e levantou " + valor + "€");
                    saldo -= valor;
                    subtrair = false;
                    TextView edt = (TextView) findViewById(R.id.edt);
                    edt.setText("O seu saldo é " + saldo + "€");
                }
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("");
            }
        });

        buttonPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + ".");
            }
        });
    }
}