package com.example.android.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// COMPLETED (1) Use Android Studio's Activity wizard to create a new Activity called ChildActivity

public class ChildActivity extends AppCompatActivity {

    // TODO (6) Create a TextView field to display your message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        // TODO (7) Get a reference to your TextView in Java
    }
}
