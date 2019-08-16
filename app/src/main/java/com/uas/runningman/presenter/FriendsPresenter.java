// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.uas.runningman.data.model.Friends;
import com.uas.runningman.data.repo.FriendsRepository;
import com.uas.runningman.view.FriendsView;

import java.util.List;



public class FriendsPresenter {

    private FriendsRepository repo;
    private FriendsView view;
    private LiveData<List<Friends>> allFriends;

    public FriendsPresenter(Context context, FriendsView view) {
        this.view = view;
        repo = new FriendsRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<Friends>>() {
            @Override
            public void onChanged(@Nullable List<Friends> friends) {
                view.showFriendsList(friends);
            }
        });
    }
}
