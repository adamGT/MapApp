package com.example.mapapp.Features.ROOM;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "item_name")
    public String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
