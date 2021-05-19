package com.example.bai_2room_db_custome;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.bai_2room_db_custome.DiaChi.class},version = 1)
public abstract  class ConnectDB extends RoomDatabase {
    private static  final String DATABASE_NAME = "DiaChi.db";
    private static  ConnectDB instance;
    public static  synchronized ConnectDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ConnectDB.class,DATABASE_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract com.example.bai_2room_db_custome.DiaChiDAO diaChiDAO();
}
