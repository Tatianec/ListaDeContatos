package com.example.app7_listacontatos.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app7_listacontatos.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contacts;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> values) {
        super(context, resource, values);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.BLACK);
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(getItem(position).getNickname());
        }
        return textView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.BLACK);
        if(getItem(position) == null){
            textView.setText("");
        }else {
            textView.setText(getItem(position).getNickname());
        }
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}
