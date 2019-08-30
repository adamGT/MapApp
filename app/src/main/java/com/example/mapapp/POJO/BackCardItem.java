package com.example.mapapp.POJO;

public class BackCardItem {

    private String itemName;
    private int itemIconId;

    public BackCardItem(String itemName, int itemIconId) {
        this.itemName = itemName;
        this.itemIconId = itemIconId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemIconId() {
        return itemIconId;
    }

    public void setItemIconId(int itemIconId) {
        this.itemIconId = itemIconId;
    }
}
