package com.example.app7_listacontatos.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app7_listacontatos.R;

import com.example.app7_listacontatos.dao.ContactDatabase;
import com.example.app7_listacontatos.dao.UserDatabase;
import com.example.app7_listacontatos.model.Contact;
import com.example.app7_listacontatos.model.User;

import java.util.List;

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String name;
        String password;
        String confPassord;
        List<Contact> contacts;

        if ( editTextName != null && editTextPassword != null && editTextConfPassword != null ) {
            name = String.valueOf(editTextName.getText());
            password = String.valueOf(editTextPassword.getText());
            confPassord = String.valueOf(editTextConfPassword.getText());
            contacts = ContactDatabase.getInstance().getAllContacts();

            if ( password.equals(confPassord)) {
                User user = new User(name, password, confPassord, contacts);

                UserDatabase.getInstance().addUser(user);

                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home);
            } else {
                Toast.makeText(this, "Favor verificar os campos informados! As senhas precisam ser iguais",
                        Toast.LENGTH_LONG).show();
            }

        }
    }
}