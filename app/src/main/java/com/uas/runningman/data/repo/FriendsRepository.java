// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.uas.runningman.data.db.AppDatabase;
import com.uas.runningman.data.db.FriendsDao;
import com.uas.runningman.data.model.Friends;

import java.util.List;



public class FriendsRepository {
    private FriendsDao friendsDao;
    private LiveData<List<Friends>> friendsList;

    public FriendsRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        friendsDao = db.friendsDao();
        friendsList = friendsDao.getAll();
    }

    public LiveData<List<Friends>> getAllFriends() {
        return friendsList;
    }

    public void insertFriend(Friends friends) {
        new insertAsync(friendsDao).execute(friends);
    }

    public void updateFriend(Friends friends) {
        new updateAsync(friendsDao).execute(friends);
    }

    public void deleteFriend(Friends friends) {
        new deleteAsync(friendsDao).execute(friends);
    }

    private static class insertAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        insertAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.addFriend(friends);
            return null;
        }
    }

    private static class updateAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        updateAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.updateFriend(friends);
            return null;
        }
    }

    private static class deleteAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        deleteAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.deleteFriend(friends);
            return null;
        }
    }
}
