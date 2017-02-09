package com.kkontus.refreshlist;

import android.database.Cursor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kristijan on 09/02/2017.
 */

abstract public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    protected int id = 0;
    protected int status = 0;
    protected long dateModified = 0l;

    public Entity(int id, int status) {
        long lDateTime = new Date().getTime();

        this.id = id;
        this.status = status;
        this.dateModified = lDateTime;
    }

    public Entity() {
        long lDateTime = new Date().getTime();

        this.status = 1;
        this.dateModified = lDateTime;
    }

    public Entity(Cursor cursor) throws Exception {
        this.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        this.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
        this.setDateModified(cursor.getLong(cursor.getColumnIndex("dateModified")));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public long getDateModified() {
        return dateModified;
    }

    public void setDateModified(long dateModified) {
        this.dateModified = dateModified;
    }

}