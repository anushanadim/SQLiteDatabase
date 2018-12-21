package com.example.anushanadim.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE="database.db";
    public static final String TABLE="contacs";
    public static final String NAME="name";
    public static final String NUM="num";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable="CREATE TABLE "+TABLE+" ("+NAME+" Text,"+NUM+" Integer);";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE+";");

    }

    public  void addData(String name,int num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(NAME,name);
        contentValues.put(NUM,num);

        db.insert(TABLE,null,contentValues);
    }

    public List<Contacts> show()
    {
        List<Contacts> contactsList=new ArrayList<>();

        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE+";",null);

        StringBuffer stringBuffer=new StringBuffer();

        while (cursor.moveToNext())
        {
            Contacts contacts=new Contacts();

            String name=cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int num=cursor.getInt(cursor.getColumnIndexOrThrow("num"));

            contacts.setName(name);
            contacts.setNum(num);

            stringBuffer.append(contacts);
            contactsList.add(contacts);
        }

        return contactsList;

    }

    public void update(String name,int num)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NUM, num);
        db.update(TABLE,contentValues ,"name='"+name+"'" ,null );
    }

    public List<Contacts> showReciever(String recieverName)
    {
        List<Contacts> contactsList=new ArrayList<>();

        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE+" WHERE name='"+recieverName+"';",null);

        StringBuffer stringBuffer=new StringBuffer();

        while (cursor.moveToNext())
        {
            Contacts contacts=new Contacts();

            String name=cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int num=cursor.getInt(cursor.getColumnIndexOrThrow("num"));

            contacts.setName(name);
            contacts.setNum(num);

            stringBuffer.append(contacts);
            contactsList.add(contacts);
        }

        return contactsList;

    }
}
