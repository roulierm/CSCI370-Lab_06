package com.example.database.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.database.dao.PersonDao;
import com.example.database.entity.Person;

@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}