// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.uas.runningman.data.db.AppDatabase;
import com.uas.runningman.data.db.UserDao;
import com.uas.runningman.data.model.User;



public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public LiveData<User> selectUser(String username, String password) {
        return userDao.login(username, password);
    }

    public void insertUser(User user) {
        new insertAsync(userDao).execute(user);
    }

    private static class insertAsync extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        insertAsync(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.addUser(user);
            return null;
        }
    }
}
