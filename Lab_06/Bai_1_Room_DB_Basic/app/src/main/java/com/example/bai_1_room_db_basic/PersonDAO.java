package com.example.bai_1_room_db_basic;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDAO {
    @Insert
    void addPerson(Person person);
    @Query("Select * from person")
    List<Person> getAllPersons();
}
