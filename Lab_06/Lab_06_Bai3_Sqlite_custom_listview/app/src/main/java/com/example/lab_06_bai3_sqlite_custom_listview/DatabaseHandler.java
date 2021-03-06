package com.example.lab_06_bai3_sqlite_custom_listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "travelManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "travels";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void addStudent(Travel student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Travel getStudent(int studentId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[] { String.valueOf(studentId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Travel student = new Travel(cursor.getInt(0), cursor.getString(1));
        return student;
    }

    public List<Travel> getAllStudents() {
        List<Travel>  studentList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Travel student = new Travel(cursor.getInt(0), cursor.getString(1));
            studentList.add(student);
            cursor.moveToNext();
        }
        return studentList;
    }

    public void updateStudent(Travel student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());

        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(student.getId()) });
        db.close();
    }

    public void deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(studentId) });
        db.close();
    }
}
