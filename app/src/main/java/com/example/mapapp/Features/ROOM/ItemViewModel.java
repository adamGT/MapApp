package com.example.mapapp.Features.ROOM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private ItemsRepository repository;
    private LiveData<List<Item>> allItems;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemsRepository(application);
        allItems = repository.getEveryItem();
    }

    public void insert(Item item){
        repository.insetAnItem(item);
    }

    public void delete(Item item){
        repository.deleteAnItem(item);
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }
}
