package com.example.banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
Autores
Pedro 11677
Leonardo 11830
 */

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_login;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBHelper(this); //chama a base de dados

        et_username = (EditText) findViewById(R.id.et_username); //campo de texto username
        et_password = (EditText) findViewById(R.id.et_password); //campo de texto password

        bt_login = (Button) findViewById(R.id.bt_login); //botao login

        bt_login.setOnClickListener(new View.OnClickListener() { //validacao de login ao carregar no botao login
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.equals("")) { //no caso de nao se escrever nada no campo "username" aparece uma mensagem de erro
                    Toast.makeText(MainActivity.this, "Username não inserido, por favor tente novamente", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) { //no caso de nao se escrever nada no campo "password" aparece uma mensagem de erro
                    Toast.makeText(MainActivity.this, "Password não inserido, por favor tente novamente", Toast.LENGTH_SHORT).show();
                } else {
                    String res = db.ValidarLogin(username, password); //no caso ambos os campos estarem preenchidos ele vai verificar com a bd

                    if (res.equals("OK")) { //se a bd confirmar o login entra na aplicacao
                        Toast.makeText(MainActivity.this, "Login efetuado", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    } else { //se a bd nao confirmar o login, da mensagem de erro
                        Toast.makeText(MainActivity.this, "Login incorreto, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}