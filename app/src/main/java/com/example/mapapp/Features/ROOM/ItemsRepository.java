package com.example.mapapp.Features.ROOM;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

//import javax.inject.Inject;

public class ItemsRepository {

    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;

//    @Inject
    public ItemsRepository (Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        itemDao = database.itemDao();
        allItems = itemDao.getAllItems();
    }

    public void insetAnItem(Item item){
        new InsertItemAsyncTask(itemDao).execute(item);
    }

    public void deleteAnItem(Item item){
        new DeleteItemAsyncTask(itemDao).execute(item);
    }

    public LiveData<List<Item>> getEveryItem (){
        return allItems;
    }



    //don't use AsyncTask

    private static class InsertItemAsyncTask extends AsyncTask<Item ,Void ,Void>{
        private ItemDao itemDao;

        private InsertItemAsyncTask(ItemDao itemDao){
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insertItem(items[0]);
            return null;
        }
    }
    private static class DeleteItemAsyncTask extends AsyncTask<Item ,Void ,Void>{
        private ItemDao itemDao;

        private DeleteItemAsyncTask(ItemDao itemDao){
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.deleteItem(items[0]);
            return null;
        }
    }

}
