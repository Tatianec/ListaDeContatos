package com.example.app7_listacontatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app7_listacontatos.R;

import com.example.app7_listacontatos.dao.UserDatabase;
import com.example.app7_listacontatos.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonNewUser;
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonLogin;

    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNewUser = findViewById(R.id.button_new_user);
        buttonNewUser.setOnClickListener(this);

        editTextName = findViewById(R.id.text_name);
        editTextPassword = findViewById(R.id.text_password);

        buttonLogin = findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.button_new_user:
                criarNovoUsuario();
                break;
            case (R.id.button_login):
                verificarLogin();
                break;
        }
    }

    public void criarNovoUsuario(){
            Intent newUser = new Intent(getApplicationContext(), NewUserActivity.class);
            startActivity(newUser);
    }

    public void verificarLogin(){

        String username = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();

        if (UserDatabase.getInstance().validateUser(username, password)) {
            Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Usuário não encontrado!", Toast.LENGTH_LONG).show();
        }
    }

}