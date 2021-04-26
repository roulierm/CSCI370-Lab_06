package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.database.async.AddPersonAsync;
import com.example.database.async.GetAllPersonsAsync;
import com.example.database.database.LabDatabase;
import com.example.database.entity.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button addPersonButton;
    private Button getAllPersonsButton;
    private LabDatabase labDB;
    private String DATABASE_NAME = "DemoPerson";
    private Person person;
    public static ArrayList<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        addPersonButton = findViewById(R.id.add_person_button);
        getAllPersonsButton = findViewById(R.id.get_all_persons_button);

        labDB = Room.databaseBuilder(this,LabDatabase.class,DATABASE_NAME).build();

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);
                Person person = new Person();
                person.setName(editText.getText().toString());
                addPersonAsync.execute();

                editText.setText("");
            }
        });
        getAllPersonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GetAllPersonsAsync getAllPersonsAsync = new GetAllPersonsAsync(labDB, getApplicationContext());
                getAllPersonsAsync.execute();

            }
        });
    }
}