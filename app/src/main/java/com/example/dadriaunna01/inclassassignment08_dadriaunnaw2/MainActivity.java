package com.example.dadriaunna01.inclassassignment08_dadriaunnaw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
    }
}
