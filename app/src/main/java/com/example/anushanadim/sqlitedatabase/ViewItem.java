package com.example.anushanadim.sqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewItem extends AppCompatActivity {

    TextView name,num;
    Button send;
    EditText nameSend,numSend;
    DatabaseHelper databaseHelper=new DatabaseHelper(ViewItem.this,DatabaseHelper.DATABASE ,null ,1 );
    List<Contacts> contactsList;
    String senderNameStr,senderNumStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        name=findViewById(R.id.name);
        num=findViewById(R.id.num);
        send=findViewById(R.id.send);
        nameSend=findViewById(R.id.nameSend);
        numSend=findViewById(R.id.numSend);

        getIncomingIntent();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recievrNameStr=nameSend.getText().toString();
                String valueStr=numSend.getText().toString();

                int newSenderNum=Integer.valueOf(senderNumStr)-Integer.valueOf(valueStr);


                databaseHelper.update(senderNameStr,newSenderNum);

                contactsList=new ArrayList<>();
                contactsList=databaseHelper.showReciever(recievrNameStr);

                String recieverName=contactsList.get(0).name;
                int recieverNum=contactsList.get(0).num;

                recieverNum=recieverNum+Integer.valueOf(valueStr);


                databaseHelper.update(recieverName,recieverNum );

                name.setText("");
                num.setText("");

                Intent intent=new Intent(ViewItem.this,Display.class);
                startActivity(intent);
            }
        });

    }

    public void getIncomingIntent()
    {

        if(getIntent().hasExtra("name")&&getIntent().hasExtra("num"))
        {
            senderNameStr=getIntent().getStringExtra("name");
            senderNumStr=getIntent().getStringExtra("num");

            name.setText(senderNameStr);
            num.setText(senderNumStr);

        }

    }
}
