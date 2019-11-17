package com.example.mapapp.Features.ROOM;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

        @Query("SELECT * FROM item")
        LiveData<List<Item>> getAllItems();

        @Insert
        void insertItem(Item item);

        @Delete
        void deleteItem(Item item);
}
