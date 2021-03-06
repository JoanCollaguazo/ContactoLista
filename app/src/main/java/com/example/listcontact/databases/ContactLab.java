package com.example.listcontact.databases;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class ContactLab {

    @SuppressLint("StaticFieldLeak")
    private static ContactLab sContactoLab;

    private ContactDAO mContactoDao;

    public ContactLab(Context context){
        Context appContext = context.getApplicationContext();
        ContactDataBase database = Room.databaseBuilder(appContext, ContactDataBase.class,"contacto")
                .allowMainThreadQueries().build();
        mContactoDao=database.getContactDao();

    }
    public static ContactLab get(Context context){
        if(sContactoLab==null){
            sContactoLab=new ContactLab(context);
        }
        return sContactoLab;

    }
    public List<Contact> getContactos(){

        return  mContactoDao.getContact();
    }

    public Contact getContacto(String n){

        return mContactoDao.getContact(n);
    }
    public void addContacto(Contact c){

        mContactoDao.addContacto(c);
    }


}
