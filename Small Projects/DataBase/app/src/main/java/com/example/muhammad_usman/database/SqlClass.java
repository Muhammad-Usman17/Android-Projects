package com.example.muhammad_usman.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

/**
 * Created by Muhammad_Usman on 5/1/2016.
 */
public class SqlClass extends SQLiteOpenHelper{

    private  static  final int DATABASE_VERSION= 1;

    private  static final String DATABASE_NAME="emailManager";

    private static final String TABLE_CONTACTS="contacts";

    private static  final  String KEY_ID="id";
    private static  final  String KEY_NAME="name";
    private static  final  String KEY_EMAIL="email";

    public  SqlClass(Context context)

    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int old,int newVersion)
    {
        db.execSQL("DROP TABLE IF EXITS"+TABLE_CONTACTS);
        onCreate(db);
    }

    void addContact(SetGet contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.getNames());
        values.put(KEY_EMAIL,contact.getEmails());
        db.insert(TABLE_CONTACTS,null,values);
        db.close();

    }
   public void updateContact(SetGet contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.getNames());
        values.put(KEY_EMAIL,contact.getEmails());
         db.update(TABLE_CONTACTS,values,KEY_ID+" = ?",
                new String[]{String.valueOf(contact.getIDs())});
        db.close();

    }

    public  void deleteContact(SetGet contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_CONTACTS,KEY_ID+" = ?",new String[]{String.valueOf(contact.getIDs())});


    }
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(" SELECT * FROM "+TABLE_CONTACTS,null);
        return cur;
    }


}
