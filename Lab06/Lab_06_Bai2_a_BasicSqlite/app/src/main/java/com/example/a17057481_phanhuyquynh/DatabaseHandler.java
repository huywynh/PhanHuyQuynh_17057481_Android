package com.example.a17057481_phanhuyquynh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Student_db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_student_table=String.format("create table %1$s(%2$s integer primary key, %3$s text)",TABLE_NAME, KEY_ID, KEY_NAME);
        db.execSQL(create_student_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table=String.format("drop table if exists %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }
    public void addStudent(Student student) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAME,student.getName());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public void addStudentName(String StudentName) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAME,StudentName);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<Student> getStudentName() {
        List<Student> studentList=new ArrayList<>();
        String query = "select "+ KEY_NAME +" from " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Student student = new Student(cursor.getString(0));
            studentList.add(student);
            cursor.moveToNext();
        }
        return studentList;
    }
    public void deleteStudent(String studentName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_NAME + " = ?", new String[] { String.valueOf(studentName) });
        db.close();
    }
}
