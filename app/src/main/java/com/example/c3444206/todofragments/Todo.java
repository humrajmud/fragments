package com.example.c3444206.todofragments;

import java.util.Date;
import java.util.UUID;

//TodoFragment sits between the model and the view and supports
// the getter and setter methods for the data in the view.
//The TodoFragment onCreate method instantiates the
// Todo model. This is not yet defined and we shall do that next.
//Android treats the Fragment classes as controllers that can only have their views
// displayed when they are added to an Activity. This
// is acheived with the Fragment Manager class that keeps track of the
// Fragment and the Back Stack objects.
public class Todo {

    private UUID mId;
    private String mTitle;
    private String mDetail;
    private Date mDate;
    private boolean mIsComplete;

    public Todo() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public void setIsComplete(boolean todoIsComplete) {
        mIsComplete = todoIsComplete;
    }

    public boolean isIsComplete() {

        return mIsComplete;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDetail() {
        return mDetail;
    }

    public Date getDate() {
        return mDate;
    }

    public void setId(UUID todoId) {
        mId = todoId;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }

    public void setDate(Date todoDate) {
        mDate = todoDate;
    }
}