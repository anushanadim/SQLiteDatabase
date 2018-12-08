package com.example.anushanadim.sqlitedatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactsViewAdapter extends RecyclerView.Adapter<ContactsViewHolder> {

    List<Contacts> contactList;

    public ContactsViewAdapter(List<Contacts> contactList) {
        this.contactList = contactList;

    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        ContactsViewHolder contactsViewHolder=new ContactsViewHolder(view);
        return contactsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {

        holder.name.setText(contactList.get(position).name);
        int numInt=contactList.get(position).num;
        String numStr=String.valueOf(numInt);
        holder.num.setText(numStr);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
