package com.example.dadriaunna01.inclassassignment08_dadriaunnaw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String displayChildren;
    private TextView displayView;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference childrenRef = database.getReference("children");
    private ArrayList<Children> childrenList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayView = (TextView) findViewById(R.id.update_view);
        displayChildren = displayView.getText().toString();

        childrenRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                childrenList.add(dataSnapshot.getValue(Children.class));
                displayNew();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Children.class) + "has changed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(Children.class) + "is removed", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void displayNew() {
        String text = "";
        for (Children a : childrenList)
            text += a + "\n";
        displayView.setText(text);

    }

    public void add(View view) {
        Intent addChild = new Intent(this, ChildReport.class);
        startActivity(addChild);
    }
    }

