package com.example.database.async;

//import android.content.Context;
import android.os.AsyncTask;

import com.example.database.database.LabDatabase;
import com.example.database.entity.Person;
import com.example.database.dao.PersonDao;
import java.util.ArrayList;
import java.util.List;

public class AddPersonAsync extends AsyncTask<Person, String, String> {
    private LabDatabase database;
    private ArrayList<android.app.Person> personArrayList;
    //private Context context;
    private String name;
    private Person person;

    public AddPersonAsync(LabDatabase labDatabase){
        this.database= labDatabase;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Person person =new Person();
                person.setName(name);
                labDatabase.personDao().insertPerson(person);
            }
        }) .start();
    }




    @Override
    protected String doInBackground(Person... people) {
        database.personDao().insertPerson(person);
        return null;
    }
}
