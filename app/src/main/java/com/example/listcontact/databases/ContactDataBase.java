package com.example.listcontact.databases;

import androidx.room.RoomDatabase;

public abstract class ContactDataBase extends RoomDatabase {

    public abstract ContactDAO getContactDao();






}
