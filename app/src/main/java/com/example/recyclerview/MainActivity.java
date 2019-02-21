package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.adapter.ContactsAdapter;
import com.example.recyclerview.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rvContact);
        contacts = Contact.createContactsList (numContacts:10);
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (context:this);
        rv.setAdapter(contactsAdapter);
        rv.setLayoutManager(layoutManager);
    }
}
