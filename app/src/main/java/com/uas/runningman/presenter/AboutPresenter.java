// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.presenter;

import com.uas.runningman.view.AboutView;



public class AboutPresenter {

    private AboutView view;

    public AboutPresenter(AboutView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else {
            view.showCreator();
        }
    }
}
