package com.example.anushanadim.sqlitedatabase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContactsViewHolder extends RecyclerView.ViewHolder {

    TextView name,num;
    RelativeLayout parentlayout;

    public ContactsViewHolder(View itemView) {
        super(itemView);

        name=(TextView)itemView.findViewById(R.id.name);
        num=(TextView)itemView.findViewById(R.id.num);
        parentlayout=itemView.findViewById(R.id.parentlayout);
    }
}
