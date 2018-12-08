package com.example.anushanadim.sqlitedatabase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ContactsViewHolder extends RecyclerView.ViewHolder {

    TextView name,num;

    public ContactsViewHolder(View itemView) {
        super(itemView);

        name=(TextView)itemView.findViewById(R.id.name);
        num=(TextView)itemView.findViewById(R.id.num);
    }
}
