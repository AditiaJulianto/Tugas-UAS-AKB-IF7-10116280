// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.uas.runningman.preference.UserPreference;
import com.uas.runningman.view.MainView;


public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
