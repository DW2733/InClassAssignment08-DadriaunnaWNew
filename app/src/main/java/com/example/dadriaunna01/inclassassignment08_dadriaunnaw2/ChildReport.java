package com.example.dadriaunna01.inclassassignment08_dadriaunnaw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChildReport extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference childAdded = database.getReference("childAdded");

    private CheckBox daycare;
    private EditText name;
    private EditText age;

    public ChildReport(boolean daycare1, String name1, int ogAge) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_report);

        daycare = (CheckBox) findViewById(R.id.day_care);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
    }

    public void addToList(View view) {

        String newName = name.getText().toString();
        String stringAge = age.getText().toString();
        int ogAge = Integer.parseInt(stringAge);
        boolean daycare1 = daycare.isChecked();

        childAdded.push().setValue(new ChildReport(daycare1, newName, ogAge));

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
