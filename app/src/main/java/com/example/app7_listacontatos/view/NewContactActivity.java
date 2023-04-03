package com.example.app7_listacontatos.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app7_listacontatos.R;
import com.example.app7_listacontatos.model.Contact;
import com.example.app7_listacontatos.model.User;

public class NewContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextNickname;
    private EditText editTextName;
    private EditText editTextPhone;
    private Button buttonSave;

    @SuppressLint( "MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        editTextNickname = findViewById(R.id.text_nickname);
        editTextName = findViewById(R.id.text_contact_name);
        editTextPhone = findViewById(R.id.text_phone);

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
        String nickname;
        String name;
        String phone;

        if ( editTextNickname != null && editTextName != null && editTextPhone != null )

        {
            nickname = String.valueOf(editTextNickname.getText());
            name = String.valueOf(editTextName.getText());
            phone = String.valueOf(editTextPhone.getText());

            Contact contact = new Contact(nickname, name, phone);

            User currentUser = ( User ) getIntent().getSerializableExtra("user");
            currentUser.addContact(contact);
            Intent contactActivity = new Intent(getApplicationContext(), ContactsActivity.class);
            contactActivity.putExtra("user", currentUser);
            startActivity(contactActivity);
            finish();
        }
        else{
            Toast.makeText(this, "Favor verificar os campos informados!",
                    Toast.LENGTH_LONG).show();
        }
    }
}