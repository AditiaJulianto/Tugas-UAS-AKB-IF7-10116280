// NIM = 10116280 //
// NAMA = ADITIA JULIANTO //
// KELAS = AKB-7 //
// 15/08/2019 //
package com.uas.runningman.presenter;

import com.uas.runningman.view.ContactView;


public class ContactPresenter {

    private ContactView view;

    public ContactPresenter(ContactView view) {
        this.view = view;
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void openTwitter() {
        view.actionTwitter();
    }
}
