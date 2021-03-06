package com.example.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.Contact;

import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    //atribut
    private List<Contact> mContact;

    //construktor
    public ContactsAdapter(List<Contact> mContact){
        this.mContact = mContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //menghubungkan ke adapter
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) { // mensetting / menghubungkan nilai maising item
        Contact itemContact = mContact.get(i);
        TextView textView = viewHolder.nameTextView;
        textView.setText(itemContact.getmName());

        Button buttonContact = viewHolder.messageButton;
        buttonContact.setText(itemContact.isOnline()? "Message" : "Offline");
        buttonContact.setEnabled(itemContact.isOnline());
    }

    @Override
    public int getItemCount() {
        return mContact.size(); //mengembalikan panjangnya data
    }

    public class ViewHolder extends RecyclerView.ViewHolder { //membantu membuat itemnya biar banyak
        private TextView nameTextView;
        private Button messageButton;
        public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nameTextView = itemView.findViewById(R.id.contact_name);
                messageButton = itemView.findViewById(R.id.message_button);
            }

        }
    }
