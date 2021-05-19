package com.example.bai_2room_db_custome;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DiaChiDAO {
    @Insert
    void addDiaChi(DiaChi diaChi);
    @Query("Select * from diachi")
    List<DiaChi> getAllDiaChi();
    @Delete
    void deleteDiaChi(DiaChi diaChi);

    @Update
    void updateDiachi(DiaChi diaChi);
}
