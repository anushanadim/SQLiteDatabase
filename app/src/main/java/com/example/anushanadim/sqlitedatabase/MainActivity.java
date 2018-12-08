package com.example.anushanadim.sqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,num;
    Button submit,show;
    DatabaseHelper databaseHelper=new DatabaseHelper(this,DatabaseHelper.DATABASE,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        num=findViewById(R.id.num);
        submit=findViewById(R.id.submit);
        show=findViewById(R.id.show);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr=name.getText().toString();
                String numStr=num.getText().toString();
                int numInt=Integer.valueOf(numStr);

                databaseHelper.addData(nameStr,numInt);

                name.setText("");
                num.setText("");

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Display.class);
                startActivity(intent);
            }
        });
    }
}
