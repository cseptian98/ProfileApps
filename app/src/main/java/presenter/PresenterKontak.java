package presenter;

import view.ViewKontak;

//5-8-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterKontak {

    private ViewKontak view;

    public PresenterKontak(ViewKontak view) {
        this.view = view;
    }

    public void makeCall() {
        view.doCall();
    }

    public void sendEmail() {
        view.sendEmail();
    }

    public void openInstagram() {
        view.openInstagram();
    }

    public void openTwitter() {
        view.openTwitter();
    }
}
