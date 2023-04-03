package com.example.app7_listacontatos.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app7_listacontatos.R;
import com.example.app7_listacontatos.model.Contact;
import com.example.app7_listacontatos.model.User;
import com.example.app7_listacontatos.view.adapter.ContactAdapter;

import java.util.List;

public class ContactsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private TextView textNickName;
    private TextView textPhone;
    private Button buttonNewContact;
    private Spinner listContactSpinner;
    private User user;

    @SuppressLint( "MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        textNickName = findViewById(R.id.text_nickname);
        textPhone = findViewById(R.id.text_phone);

        buttonNewContact = findViewById(R.id.button_create_new_contact);

        buttonNewContact.setOnClickListener(this);

        listContactSpinner = findViewById(R.id.spinner_contact);
        listContactSpinner.setOnItemSelectedListener(this);

        user = ( User ) getIntent().getSerializableExtra("user");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateSpinner();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = ( Contact ) listContactSpinner.getItemAtPosition(position);
        if ( contact != null ) {
            textNickName.setText(contact.getName());
            textPhone.setText(contact.getPhone());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.button_create_new_contact:
                criarNovoContato();
                break;
        }
    }

    public void criarNovoContato() {
        Intent newUserIntent = new Intent(getApplicationContext(), NewContactActivity.class);
        newUserIntent.putExtra("user", user);
        startActivity(newUserIntent);
        finish();
    }

    private void populateSpinner() {
        List<Contact> dataset = user.getContacts();
        dataset.add(0, null);
        ContactAdapter adapter = new ContactAdapter(this, android.R.layout.simple_spinner_item, dataset);
        listContactSpinner.setAdapter(adapter);
    }

}