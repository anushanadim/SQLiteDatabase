package com.example.anushanadim.sqlitedatabase;

import android.content.Context;
import android.content.Intent;
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
    Context context;

    public ContactsViewAdapter(List<Contacts> contactList,Context context) {
        this.contactList = contactList;
        this.context=context;
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

        final String nameStr=contactList.get(position).name;
        holder.name.setText(nameStr);
        int numInt=contactList.get(position).num;
        final String numStr=String.valueOf(numInt);
        holder.num.setText(numStr);

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ViewItem.class);
                intent.putExtra("name", nameStr);
                intent.putExtra("num",numStr );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
