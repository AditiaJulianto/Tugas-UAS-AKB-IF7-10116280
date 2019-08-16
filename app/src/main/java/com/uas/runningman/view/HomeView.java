// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.view;

import com.uas.runningman.data.model.User;



public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
