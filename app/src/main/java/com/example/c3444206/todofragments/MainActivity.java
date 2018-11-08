package com.example.c3444206.todofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    //The Activity class uses a Fragment manager and Fragment manager
    // transactions to keep track of the Back Stack and the Fragments.
    // Here is the code for a Fragment Manager to add the TodoFragment to the TodoActivity
//Note the .add method is adding the todoFragment to the calling Activity's view.
// That is, a fragment is inserted into FrameLayout view object of the MainActivity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            TodoFragment todoFragment = new TodoFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, todoFragment)
                    .commit();
        }

    }
}

//Note, the todoFragment is only instantiated if its null.
// A fragment is a subclass of Activity and may (or may not) have its own view,
// its life cycle however has more states than the parent Activity and it may well be in scope and
// exist during various state changes of its parent Activity, hence,
// the check for null to see if it already exists.

//So far, the Activity and View close coupling has been refactored to a dynamically
// loaded fragment into the associated Activity's container view. We now have a Fragment manager
// that introduces new complexity but provides logical clarity and code that is more easily maintained.