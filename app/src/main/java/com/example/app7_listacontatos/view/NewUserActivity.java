package com.example.app7_listacontatos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app7_listacontatos.R;

import com.example.app7_listacontatos.dao.UserDatabase;
import com.example.app7_listacontatos.model.User;

public class NewUserActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextConfPassword;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        editTextName = findViewById(R.id.text_name);
        editTextPassword = findViewById(R.id.text_password);
        editTextConfPassword = findViewById(R.id.text_conf_password);

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public void onClick(View view) {
        String name;
        String password;
        String confPassord;

        if(editTextName != null && editTextPassword != null && editTextConfPassword != null){
            name = String.valueOf(editTextName.getText());
            password = String.valueOf(editTextPassword.getText());
            confPassord = String.valueOf(editTextConfPassword.getText());

            User user = new User(name, password, confPassord);

            UserDatabase.getInstance().addUser(user);

            Intent home = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(home);
        }
    }
}