package com.example.c3444206.todofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

//This a controller class for manupilating fragments
// in a layout and it needs to extend and be a subclass of the Fragment class.

//The steps in creating a UI fragment are the same as creating an activity, nemely:
//
// 1) Crete a layout file to contain the UI widgets
// 2) Create a class to use the layout
// 3) Overide methods to inflate the view objects

public class TodoFragment extends Fragment {

    private Todo mTodo;
    private EditText mEditTextTitle;
    private Button mButtonDate;
    private CheckBox mCheckBoxIsComplete;



    //here the scope is public,
    // this is so that the method can be called by any activity that is hosting the view.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTodo = new Todo ();
        //Todo: refactor
        mTodo.setTitle("Test title");
        mTodo.setIsComplete(true);
    }


//View objects are inflated and a view object is returned
// to the hosting Activity but not from the onCreate method but the onCreateView method.


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        mEditTextTitle = (EditText) view.findViewById(R.id.todo_title);
        mEditTextTitle.setText(mTodo.getTitle());
        mEditTextTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // line is left blank on purpose
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTodo.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                // line is left blank on purpose

            }
        });

        mButtonDate = (Button) view.findViewById(R.id.todo_date);
        mButtonDate.setText(mTodo.getDate().toString());
        mButtonDate.setEnabled(false);

        mButtonDate = (Button) view.findViewById(R.id.todo_date);
        mButtonDate.setText(mTodo.getDate().toString());
        mButtonDate.setEnabled(false);

        mCheckBoxIsComplete = (CheckBox) view.findViewById(R.id.todo_complete);
        mCheckBoxIsComplete.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTodo.setIsComplete(isChecked);
            }
        });

        return view;



    }




}
