package com.example.listcontact.databases;

import androidx.annotation.BinderThread;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contacto")
    List<Contact> getContact();

    @Query("SELECT * FROM CONTACTO WHERE id LIKE :uuid")
    Contact getContact(String uuid);

    @Insert
    void addContacto(Contact c);

    @Delete
    void deleteContact(Contact c);

    @Update
    void updateContact(Contact c);

    @Query("DELETE FROM CONTACTO")
    void deleteAllContact();

}
