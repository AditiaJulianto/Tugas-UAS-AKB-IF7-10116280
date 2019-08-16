// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uas.runningman.R;
import com.uas.runningman.activity.AddEditEditFriendsActivity;
import com.uas.runningman.adapter.FriendsAdapter;
import com.uas.runningman.data.model.Friends;
import com.uas.runningman.presenter.FriendsPresenter;
import com.uas.runningman.view.FriendsView;

import java.util.ArrayList;
import java.util.List;



public class FriendsFragment extends Fragment implements FriendsView, View.OnClickListener {

    FriendsAdapter adapter;
    ArrayList<Friends> friends;
    static FriendsPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void showFriendsList(List<Friends> friends) {
        this.friends.clear();
        this.friends.addAll(friends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        rvFriends = view.findViewById(R.id.rvFriends);
        fab = view.findViewById(R.id.fabAddFriends);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        friends = new ArrayList<>();
        adapter = new FriendsAdapter(friends, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        presenter = new FriendsPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAddFriends) {
            Intent i = new Intent(getContext(), AddEditEditFriendsActivity.class);
            i.putExtra("type", 0);
            startActivity(i);
        }
    }
}
